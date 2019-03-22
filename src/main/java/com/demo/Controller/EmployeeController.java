package com.demo.Controller;

import com.alibaba.druid.util.StringUtils;
import com.demo.domain.employee.Employee;
import com.demo.domain.PageUtil;
import com.demo.domain.employee.UserLogin;
import com.demo.domain.employee.EmployeeVo;
import com.demo.util.*;
import com.demo.service.employee.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/md5")
    public ServerResponse sendMail() {
        ServerResponse response = new ServerResponse();
        String context = MD5Util.getStrMD5("15017814621");
        String a=MD5Util.getStrMD5("123456"+context);
        System.out.println(a);
        response.setData(a);
        return response;
    }

    /**
     * 增加员工信息
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ServerResponse addEmployee(@RequestBody EmployeeVo employee) {
        System.out.println("前台传的员工信息:"+employee);
        ServerResponse response = new ServerResponse();
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
            return ServerResponse.createByError("所学专业不能为空!");
        }
        int result = service.insertEmployee(employee);
        if (result == 1) {
            System.out.println("插入成功");
            SendQQMailUtil sendMail = new SendQQMailUtil();
            //生成默认密码
            String password = UUIDTool.generatePassword();
            System.out.println(password);
            try {
                sendMail.sendMail(employee.getEmail(), "恭喜你，你在我公司的入职信息已添加", "你的用户信息已被添加，默认登录密码为" + password + "，请尽快登录修改密码！");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                //查询到了刚才新增的用户id
                int id = service.getUserID(employee.getPhone());
                System.out.println("用户默认分配的id为："+id);
                password = MD5Util.getStrMD5(password + MD5Util.getStrMD5(employee.getPhone()));
                UserLogin user = new UserLogin(id, employee.getPhone(), password, employee.getFlag(), "https://weixiong.info/image/work.jpg");
                System.out.println(user);
                int insertResult = service.addUser(user);
                System.out.println("新增结果："+insertResult);
                if (insertResult == 1) {
                    response.setStatus(ResponseCode.SUCCESS);
                }
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
            response.setMsg("该号码未注册，请先注册！");
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
}
