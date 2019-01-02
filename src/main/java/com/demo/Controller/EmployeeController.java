package com.demo.Controller;

import com.demo.domain.Employee;
import com.demo.service.AllService;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
     *
     * */
    @RequestMapping(value="/employeeLevel")
    @ResponseBody
    public ServerResponse<List<Employee>> findEmployeeLevel(){
        List<Employee> employeesLevel=service.findEmployeeLevel();
        if(employeesLevel.size()>0){
            return ServerResponse.createBySuccess("查询成功",employeesLevel);
        }
        else{
            return ServerResponse.createByError("记录为空");
        }
    }
    /**
     * 返回企业所有员工信息
     * */
    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse<List<Employee>> findAllEmployee(){
        List<Employee> employees=service.findAllEmployee();
        if(employees.size()>0){
            return ServerResponse.createBySuccess("查询成功",employees);
        }
        else{
            return ServerResponse.createByError("没有该员工");
        }
    }

    /**
     *
     * 根据Id查询员工信息
     * */
    @RequestMapping(value="/getOne",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Employee>> getOne(int id){
        List<Employee> employees=service.queryEmployee(id);
        if(employees.size()>0){
            return ServerResponse.createBySuccess("查询成功",employees);
        }
        else {
            return ServerResponse.createByError("没有该员工");
        }
    }

    /**
     *根据员工id返回某员工的所有信息（部门，能力评估）
     * */
    @RequestMapping(value="/findEED",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Employee>> findEED(int id){
        System.out.print(id);
        List<Employee> employees=service.findEED(id);
        if(employees.size()>0){
            return ServerResponse.createBySuccess("查询成功",employees);
        }
        else {
            return ServerResponse.createByError("没有该员工信息");
        }
    }
}
