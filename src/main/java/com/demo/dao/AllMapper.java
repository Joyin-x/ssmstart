package com.demo.dao;

import com.demo.domain.Department;
import com.demo.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllMapper {

    /**
    * 查询所有员工信息
     * */
    List<Employee> findAllEmployee();


    /**
     * 根据id查询员工信息
     * */
    List<Employee> queryEmployee(int id);


    /**
     * 查询所有部门信息*/
    List<Department> queryAllDepartment();

}
