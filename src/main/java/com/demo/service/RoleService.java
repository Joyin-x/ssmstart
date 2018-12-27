package com.demo.service;

import com.demo.dao.RoleMapper;
import com.demo.domain.Role;
import com.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> queryAll() {

        return roleMapper.queryAll();
    }
    public List<User> findAllOrder(){
        return roleMapper.queryAllOrder();
    }
}
