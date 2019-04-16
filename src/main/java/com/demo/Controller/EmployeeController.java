package com.demo.Controller;

import com.alibaba.druid.util.StringUtils;
import com.demo.domain.employee.Employee;
import com.demo.domain.PageUtil;
import com.demo.domain.employee.UserLogin;
import com.demo.domain.employee.EmployeeVo;
import com.demo.util.*;
import com.demo.service.employee.AllService;
import com.demo.util.Base.ResponseCode;
import com.demo.util.Base.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author wwx
 * @date 2018/12/29 8:49
 **/

@Controller
@RequestMapping("/employee")
@ResponseBody
public class EmployeeController {

    @Autowired
    private AllService service;


    /**
     * 返回图片姓名和能力等级信息（图片暂时没返回）
     */
    @RequestMapping(value = "/employeeLevel")
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
        pageUtil.setPageSize(pageSize);
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
    @RequestMapping(value = "/getEmployeeInfo", method = RequestMethod.GET)
    public ServerResponse<Map<String, Object>> getEmployeeInfo(int id) {
        System.out.println(id);
        ServerResponse response = new ServerResponse();
        Map<String, Object> employeeInfo = service.getLoginInfo(id);
        System.out.println(employeeInfo);
        if (employeeInfo != null) {
            response.setData(employeeInfo);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }


    /**
     * 增加员工信息
     */
    @Transactional
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ServerResponse addEmployee(@RequestBody EmployeeVo employee) {
        ServerResponse response = new ServerResponse();
        if (StringUtils.isEmpty(employee.getName())) {
            return response.createByError("员工姓名不能为空！");
        }
        if (StringUtils.isEmpty(employee.getAddress())) {
            return response.createByError("居住地址不能为空!");
        }
        if (StringUtils.isEmpty(employee.getPhone())) {
            return response.createByError("电话号码不能为空！");
        }
        if (StringUtils.isEmpty(employee.getDepartment_id())) {
            return response.createByError("部门不能为空！");
        }
        if (StringUtils.isEmpty(employee.getProfessional())) {
            return response.createByError("所学专业不能为空!");
        }
        if (StringUtils.isEmpty(employee.getSex())) {
            return response.createByError("员工性别不能为空!");
        }
        if (StringUtils.isEmpty(employee.getBirthday())) {
            return response.createByError("员工生日不能为空!");
        }
        if (StringUtils.isEmpty(employee.getPosition())) {
            return response.createByError("员工职务不能为空!");
        }
        int count =service.checkPhone(employee.getPhone());
        if(count>0){
            response.setMsg("手机号码已存在，无法添加");
            return response;
        }
        //发送邮件和添加用户
        if (!StringUtils.isEmpty(employee.getEmail())) {
            SendQQMailUtil sendMail = new SendQQMailUtil();
            //生成默认密码
            String password = UUIDTool.generatePassword();
            try {
                sendMail.sendMail(employee.getEmail(), "你在我公司的入职信息已添加，职务为"+employee.getPosition()+"", "你的用户信息已被添加，默认登录密码为" + password + "，请尽快登录修改密码！");
                int result = service.insertEmployee(employee);
                //查询到了刚才新增的用户id
                int id = service.getUserID(employee.getPhone());
                password = MD5Util.getStrMD5(password + MD5Util.getStrMD5(employee.getPhone()));
                UserLogin user = new UserLogin(id, employee.getPhone(), password, employee.getFlag(), "https://weixiong.info/image/work.jpg");
                int insertResult = service.addUser(user);
                if (insertResult == 1) {
                    response.setStatus(ResponseCode.SUCCESS);
                }
            } catch (Exception e) {
                response.setMsg("邮箱地址不存在，发送邮件失败，员工信息未添加");
                System.out.println(e);

            } finally {
                return response;
            }
        }
        return response;
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ServerResponse userRegister(@RequestBody UserLogin userLogin) {
        ServerResponse response = new ServerResponse();
        if (userLogin.getPhone().isEmpty()) {
            response.setMsg("电话号码不能为空！");
            return response;
        }
        //判断员工表中是否有该电话号码
        Integer checkUser = service.checkUser(userLogin.getPhone());
        //为空则表明该员工不是本公司员工，不能让他注册
        if (checkUser != null) {
            //判断是否已经注册，避免重复注册
            Integer checkRegister = service.checkRegister(userLogin.getPhone());
            //为空则表示该号码还未注册
            if (checkRegister != null) {
                response.setMsg("该号码已注册，请直接登录！");
                return response;
            } else {
                userLogin.setUserId(checkUser);
                int result = service.addUser(userLogin);
                System.out.println(result);
                if (result > 0) {
                    response.setStatus(ResponseCode.SUCCESS);
                    response.setMsg("注册成功");
                }
                return response;
            }
        } else {
            response.setMsg("该用户不是本公司职工！");
            return response;
        }
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServerResponse userLogin(@RequestBody UserLogin userLogin) {
        ServerResponse response = new ServerResponse();
        Integer checkRegister = service.checkRegister(userLogin.getPhone());
        //为空则表示该号码还未注册,不能登录
        if (checkRegister == null) {
            response.setMsg("该号码未注册！");
            return response;
        } else {
            String password = service.getPassword(userLogin.getPhone());
            if (password.equals(userLogin.getPassword())) {
                Map<String, Object> loginUser = service.getLoginInfo(checkRegister);
                response.setData(loginUser);
                response.setStatus(ResponseCode.SUCCESS);
            } else {
                response.setMsg("密码错误！");
            }
            return response;
        }
    }


    /**
     * 更新用户职务和权限
     */
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public ServerResponse updateEmployee(@RequestBody EmployeeVo employeeVo) {
        ServerResponse response = new ServerResponse();
        System.out.println(employeeVo);
        int result=service.updateEmployee(employeeVo);
        if(result==1){
            //更新employee表成功
            int result1=service.updateUserFlag(employeeVo);
            if(result1==1){
                System.out.println(result1);
                response.setStatus(ResponseCode.SUCCESS);
            }
        }
        return response;
    }

    /**
     * 删除用户*/
    @RequestMapping(value = "/deleteEmployee")
    public ServerResponse deleteEmployee(int id) {
        System.out.println(id);
        ServerResponse response = new ServerResponse();
        int result=service.deleteEmployee(id);
        if(result>0){
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

}
