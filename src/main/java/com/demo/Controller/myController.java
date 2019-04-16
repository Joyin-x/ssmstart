package com.demo.Controller;

import com.alibaba.druid.util.StringUtils;
import com.demo.domain.employee.Employee;
import com.demo.domain.employee.EmployeeVo;
import com.demo.domain.employee.UpdatePassword;
import com.demo.service.task.myService;
import com.demo.util.*;
import com.demo.util.Base.ResponseCode;
import com.demo.util.Base.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/3/1 17:43
 **/
@Controller
@ResponseBody
@RequestMapping(value = "own")
public class myController {

    @Autowired
    private myService my;

    //根据id获取我的任务清单
    @RequestMapping(value="/getTaskById")
    public ServerResponse getTaskById(int id){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list=my.getTaskById(id);

        if(list.size()>0){
            response.setData(list);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 根据flag判断当前操作
     * */
    @RequestMapping(value="/getInfo")
    public ServerResponse getInfo(int id,int flag){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> myMobilizeList=null;
        /**
         * 我的工作调动*/
        if(flag==1){
            myMobilizeList=my.getMyMobilizeList(id);
            for (Map<String, Object> m : myMobilizeList)
            {
                String name=my.getDepartmentName(Integer.parseInt(m.get("original_department_id").toString()));
                m.put("original_department_id",name);
            }
        }
        //我的加班
        else if(flag==2){
            myMobilizeList=my.getMyOvertimeList(id);
            for (Map<String, Object> m : myMobilizeList)
            {
                String name=my.getDepartmentName(Integer.parseInt(m.get("department_id").toString()));
                m.put("department_id",name);
            }
            System.out.println(myMobilizeList);
        }
        //我的工资
        else if(flag==3){
            myMobilizeList=my.getMyMoneyList(id);
        }
        //我的任务
        else if(flag==4) {
            myMobilizeList=my.getTaskById(id);
        }
        if(myMobilizeList.size()>0){
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(myMobilizeList);
        }
        return response;
    }

    /**
     * 修改我的任务状态
     * */
    @RequestMapping("updateTaskStatus")
    public ServerResponse updateTaskStatus(int id){
        ServerResponse response=new ServerResponse();
        int result=my.updateTaskStatus(id);
        if(result==1){
         response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 修改密码
     * */
    @RequestMapping("/updatePassword")
    public ServerResponse updatePassword(@RequestBody UpdatePassword updatePassword){
        ServerResponse response=new ServerResponse();
        if (StringUtils.isEmpty(updatePassword.getOriginalPassword())) {
            return ServerResponse.createByError("原密码不能为空！");
        }
        if (StringUtils.isEmpty(updatePassword.getNewPassword())) {
            return ServerResponse.createByError("新密码不能为空！");
        }
        if (StringUtils.isEmpty(updatePassword.getNewPassword1())) {
            return ServerResponse.createByError("确认密码不能为空！");
        }
        Map<String,String> list=my.getPassword(updatePassword.getId());
        //电话号码和加密后的密码
        String phone=list.get("phone");
        String password=list.get("password");
        if(MD5Util.getStrMD5(updatePassword.getOriginalPassword() + MD5Util.getStrMD5(phone)).equals(password)){
            String newPassword=MD5Util.getStrMD5(updatePassword.getNewPassword() + MD5Util.getStrMD5(phone));
            updatePassword.setNewPassword(newPassword);
            //加密新密码更新
            int result=my.updatePassword(updatePassword);
            if(result==1){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }else{
            response.setMsg("原密码不正确");
        }
        return response;
    }

    /**
     * 我的信息修改
     * */
    @RequestMapping("/updateInfo")
    public ServerResponse updateMyInfo(String info,int flag,int id){
        System.out.println(info+flag+id);
        ServerResponse response=new ServerResponse();
        EmployeeVo employeeVo=new EmployeeVo();
        employeeVo.setId(id);
        //修改手机号
        if(flag==2){
            int count=my.getPhone(info);
            if(count>=1){
                response.setMsg("该手机号码已被绑定");
            }
            else{
                employeeVo.setPhone(info);
                int result=my.updatePhone(employeeVo);
                int result1=my.updateUserPhone(employeeVo);
                if(result+result1==2){
                    String newPassword=MD5Util.getStrMD5("123456"+ MD5Util.getStrMD5(info));
                    UpdatePassword updatePassword=new UpdatePassword();
                    updatePassword.setNewPassword(newPassword);
                    updatePassword.setId(id);
                    my.updatePassword(updatePassword);
                    response.setStatus(ResponseCode.SUCCESS);
                    response.setMsg("你已成功修改手机号，密码已自动重置为123456，请及时修改");
                }
            }

        }
        //修改我的性别
        else if(flag==3){
            employeeVo.setSex(info);
            int result=my.updateSex(employeeVo);
            if(result>0){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }
        //修改我的生日
        else if(flag==4){
            employeeVo.setBirthday(info);
            int result=my.updateBirthday(employeeVo);
            if(result>0){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }
        //修改我的地址
        else if(flag==5){
            employeeVo.setAddress(info);
            int result=my.updateAddress(employeeVo);
            if(result>0){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }
        //修改我毕业学校
        else if(flag==6){
            employeeVo.setSchool(info);
            int result=my.updateSchool(employeeVo);
            if(result>0){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }
        //修改我的所学专业
        else if(flag==7){
            employeeVo.setProfessional(info);
            int result=my.updateProfessional(employeeVo);
            if(result>0){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }
        return response;
    }

    /**
     * 忘记密码
     * */
    @RequestMapping("/forgetPassword")
    public ServerResponse forgetPassword(Employee employee){
        System.out.println(employee);
        ServerResponse response=new ServerResponse();
        Employee list=my.getEmployeeIDByPE(employee);
        System.out.println(list);
        int count=list.getSex();
        System.out.println(count);
        if(count==1){
            //生成随机密码
            //String password = UUIDTool.generatePassword();
            int id=list.getId();
            String newPassword=MD5Util.getStrMD5("123456"+ MD5Util.getStrMD5(employee.getPhone()));
            SendQQMailUtil sendMail = new SendQQMailUtil();
            try {
                sendMail.sendMail(employee.getEmail(), "密码已重置", "你的用户登录密码已重置为123456，请尽快登录修改密码！");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                UpdatePassword updatePassword=new UpdatePassword();
                updatePassword.setId(id);
                updatePassword.setNewPassword(newPassword);
               int result=my.updatePassword(updatePassword);
               if(result==1){
                   response.setStatus(ResponseCode.SUCCESS);
                   response.setMsg("密码已重置");
               }
            }
        }else{
            response.setMsg("输入的手机号或邮箱有误");
        }
        return response;
    }
}
