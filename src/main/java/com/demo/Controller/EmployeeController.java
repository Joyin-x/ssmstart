package com.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wwx
 * @date 2018/12/29 8:49
 **/

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    /**
     * 返回企业所有员工信息*/
    @RequestMapping("/list")
    public void findAllEmployee(){


    }

}
