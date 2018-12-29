package com.demo.Controller;

import com.demo.domain.Evaluation;
import com.demo.service.AllService;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wwx
 * @date 2018/12/29 10:16
 **/

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private AllService allService;


    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Evaluation>> getEmployeeEvaluation(int id){
        List<Evaluation> evaluations=allService.getEmployeeEvaluation(id);
        if(evaluations.size()>0){
            return ServerResponse.createBySuccess("查询成功",evaluations);
        }
        else{
            return ServerResponse.createByError("无评估信息");
        }
    }
}
