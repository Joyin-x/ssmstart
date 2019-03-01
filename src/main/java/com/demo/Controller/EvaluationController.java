package com.demo.Controller;

import com.demo.service.employee.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wwx
 * @date 2018/12/29 10:16
 **/

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private AllService allService;


//    @RequestMapping(value="/getByMobile",method= RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<List<Evaluation>> getByMobile(int id){
//
//    }
}
