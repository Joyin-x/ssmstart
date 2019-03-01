package com.demo.Controller;

import com.demo.domain.task.Task;
import com.demo.domain.mobilize.MobilizeRecord;
import com.demo.service.mobilize.MobilizeService;
import com.demo.util.ResponseCode;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/2/14 11:36
 **/
@Controller
@ResponseBody
@RequestMapping("/mobilize")
public class MobilizeController {
    @Autowired
    private MobilizeService service;

    /**
     * 获取所有的工作调动记录
     * */
    @RequestMapping("/list")
    public ServerResponse<List<MobilizeRecord>> getAllMobilize(@RequestParam(name="id",required = false)Integer id){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list;
        List<MobilizeRecord> AllList;
        if(id!=null){
            list=service.getMobilizeWithId(id);
            if(list.size()>0){
                response.setStatus(ResponseCode.SUCCESS);
                response.setData(list);
                return response;
            }
        }
        else{
            AllList=service.getAllMobilize();
            if(AllList.size()>0){
                response.setStatus(ResponseCode.SUCCESS);
                response.setData(AllList);
                return response;
            }
        }
        return response;
    }
    /**
     * 返回岗位调动记录数和姓名，id*/
    @RequestMapping("/getMobilizeWithName")
    public ServerResponse getMobilizeWithName(){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list=service.getMobilizeWithName();
        if(list.size()>0){
            response.setData(list);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 为特定员工指派任务
     * */
    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    public ServerResponse addTask(@RequestBody Task task){
        ServerResponse response=new ServerResponse();
        int result=service.addTask(task);
        if(result==1){
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 获取指派任务记录*/
    @RequestMapping("/getTaskList")
    public ServerResponse<List<Map<String,Object>>> getTaskList(){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> taskList=service.getTaskList();
        if(taskList.size()>0){
            response.setData(taskList);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

}