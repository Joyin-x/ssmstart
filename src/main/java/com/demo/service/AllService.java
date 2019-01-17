package com.demo.service;

import com.demo.dao.AllMapper;
import com.demo.domain.Department;
import com.demo.domain.Employee;
import com.demo.domain.Evaluation;
import com.demo.domain.department.DepartmentAndEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 返回指定页数的5条员工信息
     */
    public List<Employee> findAnyEmployee(int page) {
        return allMapper.findAnyEmployee(page);
    }

    /**
     * 返回员工姓名，图片，能力等级信息
     * */

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
     * 根据id查询员工能力评估信息
     * */
    public List<Evaluation> getEmployeeEvaluation(int id){
        return allMapper.getEmployeeEvaluation(id);

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
    /**
     * 返回某员工的所有信息（部门，能力评估）
     * */

    public List<Employee> findEED(int id){return allMapper.findEED(id);}
}
