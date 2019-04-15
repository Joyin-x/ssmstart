package com.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.department.Department;
import com.demo.domain.employee.EmployeeVo;
import com.demo.domain.mobilize.Mobilize;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.department.DepartmentAndId;
import com.demo.service.employee.AllService;
import com.demo.service.department.departmentService;
import com.demo.util.ResponseCode;
import com.demo.util.SendMsgUtil;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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

    @RequestMapping("/sendMsg")
    @ResponseBody
    public ServerResponse sendMsg(HttpServletResponse response, HttpServletRequest request) {
        ServerResponse baseResponse = new ServerResponse();

        //短信接口URL提交地址
        String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        String sid = "030b3e1702c948fc931c7f3c8f5667cf";
        String token = "7397a1efddcd4c3bb6b7d11c7f30c823";
        String num = SendMsgUtil.getRandNum();
        //与新增的模版内容一致
        String smsContent = "【昊天科技】您的验证码为" + num + "，请于" + 2 + "分钟内正确输入，如非本人操作，请忽略此短信。";
        //群发也可以，单发也可以
        String result = SendMsgUtil.sendMsg(url, sid, token, smsContent, "post", "15017814621");
        System.out.println("String:"+result);
        System.out.println("JSON:"+JSONObject.parseObject(result));
        System.out.println(JSONObject.parseObject(result).get("respCode").toString());
        if(JSONObject.parseObject(result).get("respCode").toString().equals("00000")){
            baseResponse.setStatus(ResponseCode.SUCCESS);
            final HttpSession session=request.getSession();
            session.setAttribute("yzm",num);
            System.out.println(session.getAttribute("yzm"));
            final Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //删除session中存的验证码
                    session.removeAttribute("yzm");
                    timer.cancel();
                }
            },1*60*1000);

        }
        baseResponse.setData(JSONObject.parseObject(result));
        return baseResponse;
    }

    @RequestMapping("/checkMsg")
    @ResponseBody
    public ServerResponse check(HttpServletResponse response, HttpServletRequest request) {
        ServerResponse response1=new ServerResponse();
        HttpSession session=request.getSession();
        if(session.getAttribute("yzm")!=null){
            response1.setData(session.getAttribute("yzm"));
        }

        return response1;

    }

    /**
     * 增加部门信息*/
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Department> addDepartment(@RequestBody Department department){
        System.out.println(department);
        ServerResponse response=new ServerResponse();
        /**
         * 1.部门表新增一条新纪录
         * 2.获取到新增的部门id
         * 3.更新员工表的员工部门和职务
         * 4.更新用户表的权限状态*/
        int result=departmentService.addDepartment(department);
        if(result==1){
            int departmentID=departmentService.getDepartmentID(department.getEmployeeId());
            Mobilize mobilize=new Mobilize();
            mobilize.setEmployeeId(department.getEmployeeId());
            mobilize.setNowDepartmentId(departmentID);
            mobilize.setNowPosition(department.getPosition());
            int result1= departmentService.updateEmployee(mobilize);
            if(result1==1){
                //更新用户表
                EmployeeVo employeeVo=new EmployeeVo();
                employeeVo.setId(department.getEmployeeId());
                employeeVo.setFlag(1);
                int result2=service.updateUserFlag(employeeVo);
                if(result2==1){
                    response.setStatus(ResponseCode.SUCCESS);
                }
            }

        }
        return response;
    }

    /**
     * 修改部门信息
     * */
    @RequestMapping(value = "/modifyDepartment",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Department> modifyDepartment(@RequestBody Department department){

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
        ServerResponse response=new ServerResponse();
        //查找要删除部门的所有员工id
        List<Integer> employeeID=departmentService.getDeleteDepartmentEmployee(id);
        /**
         * 1.考勤表记录删除（需查找到员工id删除)
         * 2.讨论表员工评论删除（需查找到员工id删除）
         * 3.员工表删除所有该部门的员工
         * 4.工作调动表删除所有的记录（需查找到员工id删除）
         * 5.公告表删除所有该部门员工发布的记录（需查找到员工id删除）
         * 6.加班申请表删除记录（需查找到员工id删除）
         * 7.任务表删除记录（需查找到员工id删除）
         * 8.删除用户表中该部门员工记录(需查找到员工id删除)
         * 9.删除工资表中该部门员工工资记录（未完成）
         * 10.删除奖惩表中该部门员工奖惩记录（未完成）
         * */
        System.out.println(employeeID.toString());
        int result=departmentService.deleteDepartment(id);
        System.out.println(result);
        if(result>0){
            int result1=departmentService.deleteDepartmentAllEmployee(employeeID);
            if(result1>0){
                System.out.println("其他表的也删除了");
                response.setMsg("其他表的也删除了");
            }
            response.setStatus(ResponseCode.SUCCESS);
            return response;
        }
        return response;
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
        System.out.println(id);
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
        int updateResult=departmentService.updateEmployee(mobilize);
        int addResult=departmentService.addMobilze(mobilize);
        if(updateResult>0&&addResult>0){
            response.setStatus(ResponseCode.SUCCESS);
            return response;
        }
        return response;
    }

    /**
     * 返回查询到的普通员工的姓名和id
     * */
    @RequestMapping(value="/getSimpleEmployee")
    @ResponseBody
    public ServerResponse getSimpleEmployee(){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list=departmentService.getSimpleEmployee();
        if(list.size()>0){
            response.setData(list);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

}
