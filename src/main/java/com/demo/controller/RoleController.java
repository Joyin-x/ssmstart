package com.demo.controller;

import com.demo.domain.Role;
import com.demo.domain.User;
import com.demo.service.RoleService;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Role> findAll() {
        return roleService.queryAll();
    }

    @RequestMapping("/userOrder")
    @ResponseBody
    public ServerResponse<List<User>> findAllOrder() {
        List<User> user=roleService.findAllOrder();
        if(user.size()>0){
            return ServerResponse.createBySuccess("查询成功",user);
        }
        else {
            return ServerResponse.createByError("查询记录为空");
        }
    }
}
