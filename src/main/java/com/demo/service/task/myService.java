package com.demo.service.task;

import com.demo.dao.myMapper;
import com.demo.domain.Image;
import com.demo.domain.employee.Employee;
import com.demo.domain.employee.EmployeeVo;
import com.demo.domain.employee.UpdatePassword;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/3/1 17:46
 **/
@Service
public class myService {

    @Autowired
    private myMapper mapper;


    //根据id获取我的任务清单
    public List<Map<String, Object>> getTaskById(int id) {
        return mapper.getTaskById(id);
    }


    //存储头像
    public int addImage(Image image) {
        return mapper.addImage(image);
    }


    //返回我的工作调动记录
    public List<Map<String,Object>> getMyMobilizeList(int id){return mapper.getMyMobilizeList(id);}


    //返回我的加班申请
    public List<Map<String,Object>> getMyOvertimeList(int id){return mapper.getMyOvertimeList(id);}


    //返回我的工资单记录
    public List<Map<String,Object>> getMyMoneyList(int id){return mapper.getMyMoneyList(id);}


    //根据部门id查找部门名字
    public String  getDepartmentName(int id){return mapper.getDepartmentName(id);}


    //修改我的任务状态
    public int updateTaskStatus(int id){return mapper.updateTaskStatus(id);}

    //获取用户的密码手机号
    public Map<String,String> getPassword(int id){return mapper.getPassword(id);}

    //修改我的密码
    public int updatePassword(UpdatePassword updatePassword){return mapper.updatePassword(updatePassword);}

    //修改手机号
    public int updatePhone(EmployeeVo employeeVo){return mapper.updatePhone(employeeVo);}
    public int updateUserPhone(EmployeeVo employeeVo){return mapper.updateUserPhone(employeeVo);}
    //修改我的地址
    public int updateAddress(EmployeeVo employeeVo){return mapper.updateAddress(employeeVo);}
    //修改我的毕业学校
    public int updateSchool(EmployeeVo employeeVo){return mapper.updateSchool(employeeVo);}
    //修改所学专业
    public int updateProfessional(EmployeeVo employeeVo){return mapper.updateProfessional(employeeVo);}

    //修改我的性别
    public int updateSex(EmployeeVo employeeVo){return mapper.updateSex(employeeVo);}
    //修改我的生日
    public int updateBirthday(EmployeeVo employeeVo){return mapper.updateBirthday(employeeVo);}

    //查看手机号码是否已存在
    public int getPhone(String phone){return mapper.getPhone(phone);}


    //通过手机号和邮箱查找用户id
    public Employee getEmployeeIDByPE(Employee employee){return mapper.getEmployeeIDByPE(employee);}
}
