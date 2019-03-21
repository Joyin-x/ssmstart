package com.demo.Controller;

import com.demo.service.employee.AllService;
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

}
