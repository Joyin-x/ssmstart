package com.demo.Controller;

import com.alibaba.druid.util.StringUtils;
import com.demo.domain.Employee;
import com.demo.domain.PageUtil;
import com.demo.domain.employee.EmployeeVo;
import com.demo.service.AllService;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wwx
 * @date 2018/12/29 8:49
 **/

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private AllService service;


    /**
     * 返回图片姓名和能力等级信息（图片暂时没返回）
     */
    @RequestMapping(value = "/employeeLevel")
    @ResponseBody
    public ServerResponse<List<Employee>> findEmployeeLevel() {
        List<Employee> employeesLevel = service.findEmployeeLevel();
        if (employeesLevel.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", employeesLevel);
        } else {
            return ServerResponse.createByError("记录为空");
        }
    }

    /**
     * 返回企业所有员工信息
     */
    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse<List<Employee>> findAllEmployee() {
        List<Employee> employees = service.findAllEmployee();
        if (employees.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", employees);
        } else {
            return ServerResponse.createByError("没有该员工");
        }
    }

    /**
     * 返回指定页数的五条员工信息
     */
    @RequestMapping(value = "/anyList", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Employee>> findAnyEmployee(int index) {
        int pageIndex = 1;//初始当前页
        int pageSize = 4;
        int number = (int) service.pageCount();//每页显示条数
        PageUtil<Employee> pageUtil = new PageUtil<Employee>();
        List<Employee> list = new ArrayList<Employee>();
        if (index > 0) {
            pageIndex = index;
        }
        List<Employee> employees = service.findAnyEmployee(index);
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageNumber(number);
        pageUtil.setPageSize(pageSize);//13/4=3...1
        pageUtil.setPageCount((int) Math.ceil((double) (pageUtil.getPageNumber() / pageUtil.getPageSize())) + 1);
        index = (pageIndex - 1) * pageSize;
        list = service.findAnyEmployee(index);
        pageUtil.setList(list);
        if (list.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", list);
        } else {
            return ServerResponse.createByError("所有数据查询完成");
        }
    }

    /**
     * 根据Id查询员工信息
     */
    @RequestMapping(value = "/getOne", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Employee>> getOne(int id) {
        List<Employee> employees = service.queryEmployee(id);
        if (employees.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", employees);
        } else {
            return ServerResponse.createByError("没有该员工");
        }
    }

    /**
     * 根据员工id返回某员工的所有信息（部门，能力评估）
     */
    @RequestMapping(value = "/findEED", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Employee>> findEED(int id) {
        List<Employee> employees = service.findEED(id);
        if (employees.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", employees);
        } else {
            return ServerResponse.createByError("没有该员工信息");
        }
    }

    /**
     * 增加员工（目前测试员工照片上传）
     */
    @RequestMapping("/addEmployeeImage")
    public void uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    /**
     * 增加员工信息
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addEmployee(@RequestBody EmployeeVo employee) {
        if (StringUtils.isEmpty(employee.getName())) {
            return ServerResponse.createByError("员工姓名不能为空！");
        }
        if (StringUtils.isEmpty(employee.getAddress())) {
            return ServerResponse.createByError("居住地址不能为空!");
        }
        if (StringUtils.isEmpty(employee.getPhone())) {
            return ServerResponse.createByError("电话号码不能为空！");
        }
        if (StringUtils.isEmpty(employee.getDepartment_id())) {
            return ServerResponse.createByError("部门id不能为空！");
        }
        if (StringUtils.isEmpty(employee.getProfessional())) {
            return ServerResponse.createByError("职称不能为空!");
        }
        int result = service.insertEmployee(employee);
        if (result == 1) {
            return ServerResponse.createBySuccess("成功增加新员工信息");
        } else {
            return ServerResponse.createByError("添加失败");
        }
    }
}
