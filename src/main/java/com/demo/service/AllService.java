package com.demo.service;

import com.demo.dao.AllMapper;
import com.demo.domain.Department;
import com.demo.domain.Employee;
import com.demo.domain.Evaluation;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.employee.EmployeeVo;
import com.demo.domain.evaluation.EmployeeAndEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AllService {

    @Autowired
    private AllMapper allMapper;


    /**
     * 返回查询所有员工信息
     */
    public List<Employee> findAllEmployee() {
        return allMapper.findAllEmployee();
    }


    /**
     * 获取总页数*/
    public int pageCount(){
        return allMapper.pageCount();
    }
    /**
     * 返回指定页数的5条员工信息
     */
    public List<Employee> findAnyEmployee(int index) {
        return allMapper.findAnyEmployee(index);
    }

    /**
     * 返回员工姓名，图片，能力等级信息
     * */

    /**
     * 增加新员工，返回信息
     * */
    public int insertEmployee(EmployeeVo employee){
        int result=allMapper.insertEmployee(employee);
        return result;
    }

    public List<Employee> findEmployeeLevel(){return allMapper.findEmployeeLevel();}

    /**
     * 查询具体员工信息
     */
    public List<Employee> queryEmployee(int id) {
        return allMapper.queryEmployee(id);
    }

    /**
     * 查询所有部门信息
     * */
    public List<Department> queryAllDepartment(){
        return allMapper.queryAllDepartment();
    }


    /**
     * 根据id查询员工个人资料和能力评估信息
     * */
    public Map<String,Object> getEmployeeAndEvaluation(int id){
        return allMapper.getEmployeeAndEvaluation(id);
    }

    /**
     * 根据部门id查询部门所有员工信息
     * */
    public List<DepartmentAndEmployee> getDepartmentEmployee(int id){
        return allMapper.getDepartmentEmployee(id);
    }
    public List<DepartmentAndEmployee> getDepartmentEmployeeAll(){
        return allMapper.getDepartmentEmployeeAll();
    }


}
