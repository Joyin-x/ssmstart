package com.demo.Controller;

import com.demo.service.task.myService;
import com.demo.util.ResponseCode;
import com.demo.util.ServerResponse;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
