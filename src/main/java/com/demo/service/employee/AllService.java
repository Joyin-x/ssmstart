package com.demo.service.employee;

import com.demo.dao.AllMapper;
import com.demo.domain.department.Department;
import com.demo.domain.employee.Employee;
import com.demo.domain.employee.UserLogin;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.employee.EmployeeVo;
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
        return allMapper.insertEmployee(employee);
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

    /**
     * 查找用户是本公司员工
     * */
    public Integer checkUser(String phone){return allMapper.checkUser(phone);}

    /**
     * 查找用户是否已注册
     * */
    public Integer checkRegister(String phone){return allMapper.checkRegister(phone);}

    /**
     * 用户注册
     * */
    public int addUser(UserLogin userLogin){return allMapper.addUser(userLogin);}


    /**
     * 验证用户登录
     * */
    public String getPassword(String phone){return allMapper.getPassword(phone);}

    /**
     * 登录成功后返回员工个人信息（id,姓名,电话号码)
     * */
    public Map<String,Object> getLoginInfo(int id){return allMapper.getLoginInfo(id);}
}
