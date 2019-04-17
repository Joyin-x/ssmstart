package com.demo.dao;

import com.demo.domain.Image;
import com.demo.domain.employee.Employee;
import com.demo.domain.employee.EmployeeVo;
import com.demo.domain.employee.UpdatePassword;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/3/1 17:44
 **/

@Mapper
public interface myMapper {

    //根据id获取我的任务清单
    List<Map<String,Object>> getTaskById(int id);

    //存储用户头像
    int addImage(Image image);
    //获取用户头像
    String getImageById(int userId);

    //返回我的工作调动记录
    List<Map<String,Object>> getMyMobilizeList(int id);

    //返回我的加班申请
    List<Map<String,Object>> getMyOvertimeList(int id);

    //返回我的工资单记录
    List<Map<String,Object>> getMyMoneyList(int id);

    //根据部门id查找部门名字
    String  getDepartmentName(int id);

    //修改我的任务状态
    int updateTaskStatus(int id);

    //修改密码
    int updatePassword(UpdatePassword updatePassword);

    //获取用户密码手机号
    Map<String,String> getPassword(int id);

    //修改手机号
    int updatePhone(EmployeeVo employeeVo);
    int updateUserPhone(EmployeeVo employeeVo);
    //修改我的地址
    int updateAddress(EmployeeVo employeeVo);
    //修改我的毕业学校
    int updateSchool(EmployeeVo employeeVo);
    //修改所学专业
    int updateProfessional(EmployeeVo employeeVo);
    //修改我的性别
    int updateSex(EmployeeVo employeeVo);
    //修改我的生日
    int updateBirthday(EmployeeVo employeeVo);

    //查看手机号码是否已存在
    int getPhone(String phone);

    //通过手机号和邮箱查找用户id
    Employee getEmployeeIDByPE(Employee employee);

}
