package com.demo.dao;

import com.demo.domain.Role;
import com.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> queryAll();

    /**
     * 查询所有的用户和订单号
     *
     */
    List<User> queryAllOrder();
}
