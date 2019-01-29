package com.demo.Controller;

import com.demo.domain.Department;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.service.AllService;
import com.demo.service.department.departmentService;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wwx
 * @date 2018/12/29 8:50
 **/

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private AllService service;
    @Autowired
    private departmentService departmentService;

    /**
     * 增加部门信息*/
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Department> addDepartment(@RequestBody Department department){
        System.out.println(department.getDepartmentName()+":"+department.getPrincipal());
        int result=departmentService.addDepartment(department);
        if(result==1){
            return ServerResponse.createBySuccess("新增部门成功");
        }
        return ServerResponse.createByError("失败");
    }

    /**
     * 修改部门信息
     * */
    @RequestMapping(value = "/modifyDepartment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Department> modifyDepartment(@RequestBody Department department){
        System.out.println(department.getId()+":"+department.getDepartmentName()+":"+department.getPrincipal());
        int result=departmentService.modifyDepartment(department);
        if(result==1){
            return ServerResponse.createBySuccess("成功修改");
        }
        return ServerResponse.createByError("失败");
    }

    /**
     * 删除部门信息
     * */
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Department> deleteDepartment(int id){
        System.out.println(id);
        int result=departmentService.deleteDepartment(id);
        if(result==1){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByError("失败");
    }

    /**
     * 返回企业所有部门信息
     * */
    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse<List<Department>> findAllDepartment(){
        List<Department> Department=service.queryAllDepartment();
        if(Department.size()>0){
            return ServerResponse.createBySuccess("查询成功",Department);
        }
        else{
            return ServerResponse.createByError("无部门信息");
        }
    }

    /**
     * 根据id返回企业部门所有员工信息
     * */
    @RequestMapping(value="/getDepartmentEmployee",method=RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DepartmentAndEmployee>> getDepartmentEmployee(int id){
        List<DepartmentAndEmployee> DepartmentAndEmployeeList;
        if(id==0){
            DepartmentAndEmployeeList=service.getDepartmentEmployeeAll();
        }else{
            DepartmentAndEmployeeList=service.getDepartmentEmployee(id);
        }
        if(DepartmentAndEmployeeList.size()>0){
            return ServerResponse.createBySuccess("查询成功",DepartmentAndEmployeeList);
        }
        else{
            return ServerResponse.createByError("无部门员工信息");
        }
    }
}
