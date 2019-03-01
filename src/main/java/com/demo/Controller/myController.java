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
        System.out.println(id);
        List<MappingChange.Map<String,Object>> list=my.getTaskById(id);
        if(list.size()>0){
            response.setData(list);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

}
