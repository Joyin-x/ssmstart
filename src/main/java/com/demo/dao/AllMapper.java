package com.demo.dao;

import com.demo.domain.Department;
import com.demo.domain.Employee;
import com.demo.domain.Evaluation;
import com.demo.domain.department.DepartmentAndEmployee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllMapper {

    /**
    * 查询所有员工信息
     * */
    List<Employee> findAllEmployee();

    /**
     * 查询指定页数的五条员工信息
     * */
    List<Employee> findAnyEmployee(int page);

    /**
     * 根据id查询员工信息
     * */
    List<Employee> queryEmployee(int id);

    /**
     * 返回员工姓名，照片，能力评估信息
     * */
    List<Employee> findEmployeeLevel();

    /**
     * 查询所有部门信息*/
    List<Department> queryAllDepartment();


    /**
     *
     * 根据员工id查询能力评估信息
     * */
    List<Evaluation> getEmployeeEvaluation(int id);

    /**
     * 根据部门id查询部门所有员工信息*/
    List<DepartmentAndEmployee> getDepartmentEmployee(int id);

    /**
     * 返回某员工的所有信息（部门，能力评估）
     * */

    List<Employee> findEED(int id);
}
