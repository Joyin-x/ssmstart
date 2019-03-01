package com.demo.Controller;

import com.demo.domain.department.Department;
import com.demo.domain.mobilize.Mobilize;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.department.DepartmentAndId;
import com.demo.service.employee.AllService;
import com.demo.service.department.departmentService;
import com.demo.util.ResponseCode;
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


    /**
     * 根据搜索框传过来的文字进行搜索，返回模糊查询的数据
     * */
    @RequestMapping(value="/searchDepartment",method=RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<DepartmentAndEmployee>> searchDepartment(String text){
        ServerResponse response=new ServerResponse();
        List<DepartmentAndEmployee> result;
        /**员工姓名搜索*/
        result=departmentService.searchDepartmentByName(text);
        if(result.size()>0){
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(result);
            return response;
        }else{
            /**部门名搜索*/
            result=departmentService.searchDepartmentByDname(text);
            if(result.size()>0){
                response.setStatus(ResponseCode.SUCCESS);
                response.setData(result);
                return response;
            }else{
                /**职务名搜索*/
                result=departmentService.searchDepartmentByPosition(text);
                if(result.size()>0){
                    response.setStatus(ResponseCode.SUCCESS);
                    response.setData(result);
                    return response;
                }
            }
        }
        return response;
    }

    /**
     *返回已有的部门和其id
     * */
    @RequestMapping(value="/getDepartmentAndId")
    @ResponseBody
    public ServerResponse<List<DepartmentAndId>> searchDepartment(){
        ServerResponse response=new ServerResponse();
        List<DepartmentAndId> result;
        result=departmentService.getDepartmentAndId();
        if(result.size()>0){
            response.setData(result);
            response.setStatus(ResponseCode.SUCCESS);
            return response;
        }
        return response;
    }

    /**
     * 修改员工所在的部门和职务
     * 新增工作调动记录
     * */
    @RequestMapping(value="/addMobilize",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addMobilize(@RequestBody Mobilize mobilize){
        ServerResponse response=new ServerResponse();
        System.out.println(mobilize.getNowPosition());
        int updateResult=departmentService.updateEmployee(mobilize);
        int addResult=departmentService.addMobilze(mobilize);
        if(updateResult>0&&addResult>0){
            response.setStatus(ResponseCode.SUCCESS);
            return response;
        }
        return response;
    }
}
