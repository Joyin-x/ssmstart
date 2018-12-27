package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaozhao
 * @date 2018/8/6上午9:29
 */

@Controller
@RequestMapping("/demo")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "你好 MVC SSM";
    }
}
