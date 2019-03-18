package com.demo.Controller;

import com.demo.domain.attendance.Attendance;
import com.demo.domain.attendance.updateAttendance;
import com.demo.domain.overtime.overTime;
import com.demo.domain.overtime.updateApprove;
import com.demo.service.overTime.overTimeService;
import com.demo.util.ResponseCode;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/overtime")
public class overTimeController {


    @Autowired
    private overTimeService overTimeService;

    /**
     * 加班申请请求
    * */
    @RequestMapping(value = "/addOverTimeRecord",method = RequestMethod.POST)
    public ServerResponse addOverTimeRecord(@RequestBody overTime overtime){
        ServerResponse response=new ServerResponse();
        System.out.println(overtime);
        int result=overTimeService.addOverTimeRecord(overtime);
        if(result==1){
            response.setData("新增成功");
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 根据部门id返回加班记录
     * */
    @RequestMapping(value = "/getApprove")
    public ServerResponse getApprove(int id){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list=overTimeService.getApprove(id);
        if(list.size()>0){
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(list);
        }
        return response;
    }

    /**
     * 根据部门id返回未审批的加班记录
     */
    @RequestMapping(value = "/getNotApprove")
    public ServerResponse getNotApprove(int id){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list=overTimeService.getNotApprove(id);
        if(list.size()>0){
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(list);
        }
        return response;
    }

    /**
     * 根据部门id返回未审批的加班记录
     * */
    @RequestMapping(value = "/approve",method = RequestMethod.POST)
    public ServerResponse approve(@RequestBody updateApprove update){
        ServerResponse response=new ServerResponse();
        int result=overTimeService.approve(update);
        if(result==1){
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 增加考勤记录
     * */
    @RequestMapping(value = "/addAttendance",method = RequestMethod.POST)
    public ServerResponse addAttendance(@RequestBody Attendance attendance){
        System.out.println(attendance);
        ServerResponse response=new ServerResponse();
        int isAttendance=overTimeService.isAttendance();
        System.out.println(isAttendance);
        //不等于0表示已经有这条签到记录
        if(isAttendance==1){
            int result=overTimeService.addAttendance(attendance);
            if(result==1){
                response.setStatus(ResponseCode.SUCCESS);
            }
        }else{
           response.setStatus(ResponseCode.notAttendance);
        }
        return response;
    }

    /**
     * 下班考勤
     * */
    @RequestMapping(value = "/updateAttendance",method = RequestMethod.POST)
    public ServerResponse addAttendance(@RequestBody updateAttendance attendance){
        ServerResponse response=new ServerResponse();
        System.out.println(attendance);
        int isAttendance=overTimeService.isAttendance();
        System.out.println(isAttendance);
        //不等于0表示已经有这条签到记录
        if(isAttendance==1){
            //查询当天该用户的考勤记录
            int id=overTimeService.getAttendance(attendance.getId());
            System.out.println(id);
            if(id!=0){
                attendance.setId(id);
                int result=overTimeService.updateAttendance(attendance);
                System.out.println(result);
                if(result==1){
                    response.setStatus(ResponseCode.SUCCESS);
                }
            }
        }else{
            response.setStatus(ResponseCode.notAttendance);
        }

        return response;
    }

}
