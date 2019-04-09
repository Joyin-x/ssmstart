package com.demo.dao;

import com.demo.domain.department.Department;
import com.demo.domain.employee.Employee;
import com.demo.domain.employee.UserLogin;
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
     * 增加新员工，返回信息
     * */
    int insertEmployee(EmployeeVo employee);

    /**
     * 查找用户是否是本公司员工
     * */
    Integer checkUser(String phone);

    /**
     * 查找用户是否已注册
     * */
    Integer checkRegister(String phone);

    /**
     * 用户注册
     * */
    int addUser(UserLogin userLogin);

    /**
     * 验证用户登录
     * */
    String getPassword(String phone);
    /**
     * 验证该手机号码是否已存在*/
    int checkPhone(String phone);
    /**
     * 登录成功后返回员工个人信息（id,姓名,电话号码)
     * */
    Map<String,Object> getLoginInfo(int id);

    /**
     * 添加用户信息后查询默认分配的用户ID*/
    int getUserID(String email);

    /**
     * 修改员工信息
     * */
    int updateEmployee(EmployeeVo employeeVo);

    /**
     * 修改员工等级权限*/
    int updateUserFlag(EmployeeVo employeeVo);

    /**
     * 删除员工*/
    int deleteEmployee(int id);
}
