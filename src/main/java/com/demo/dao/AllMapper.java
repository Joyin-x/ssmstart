package com.demo.dao;

import com.demo.domain.Department;
import com.demo.domain.Employee;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.employee.EmployeeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AllMapper {

    /**
    * 查询所有员工信息
     * */
    List<Employee> findAllEmployee();

    /**
     * 查询指定页数的五条员工信息
     * */
    List<Employee> findAnyEmployee(int index);
    /**
     * 获取总页数*/
    int pageCount();

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
     * 查询某个员工的个人信息和能力评估信息
     * */
    Map<String,Object> getEmployeeAndEvaluation(int id);

    /**
     * 根据部门id查询部门所有员工信息*/
    List<DepartmentAndEmployee> getDepartmentEmployee(int id);
    List<DepartmentAndEmployee> getDepartmentEmployeeAll();
    /**
     * 返回某员工的所有信息（部门，能力评估）
     * */

    List<Employee> findEED(int id);

    /**
     * 增加新员工，返回信息
     * */
    int insertEmployee(EmployeeVo employee);
}
