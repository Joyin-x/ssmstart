package com.demo.Controller;

import com.demo.domain.mobilize.MobilizeRecord;
import com.demo.service.mobilize.MobilizeService;
import com.demo.util.ResponseCode;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wwx
 * @date 2019/2/14 11:36
 **/
@Controller
@RequestMapping("/mobilize")
public class MobilizeController {
    @Autowired
    private MobilizeService service;


    @ResponseBody
    @RequestMapping("/list")
    public ServerResponse<List<MobilizeRecord>> getAllMobilize(){
        ServerResponse response=new ServerResponse();
        List<MobilizeRecord> list=service.getAllMobilize();
        if(list.size()>0){
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(list);
            return response;
        }
        return response;
    }
}
