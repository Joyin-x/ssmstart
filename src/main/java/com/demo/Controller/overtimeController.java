package com.demo.Controller;

import com.demo.util.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class overtimeController {


    @RequestMapping("overtimeRecord")
    public ServerResponse getoverTimeRecord(){
        ServerResponse response=new ServerResponse();


        return response;
    }
}
