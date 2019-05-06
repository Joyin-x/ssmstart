package com.demo.dao;

import com.demo.domain.department.Department;
import com.demo.domain.wage.Reward;
import com.demo.domain.wage.Wage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: 千城暮雪
 * @DATE： 2019/4/5 13:09
 * @Version 1.0.0
 */
@Mapper
public interface moneyMapper {

    /**
     * 根据id查找部门信息
     * */
    Map<String,Object> selectDepartment(int id);

    /**
     * 更新部门底薪
     * */
    int updateBasicSalary(Department department);

    /**
     * 增加奖惩记录
     * */
    int addReward(Reward reward);

    /**
     * 查看出勤天数
     * */
    int countAttendance(int id);

    /**
     * 查询某部门的所有员工id*/
    List<Map<String,Integer>> selectEmployeeID(int id);

    /**
     * 查找部门底薪
     * */
    int selectBasicSalary(int id);

    /**
     * 查询员工奖惩
     * */
    List<Map<String,Integer>> selectRewards(int id);

    /**
     * 查询员工本月加班天数
     * */
    int selectOverTime(int id);

    /**
     * 工资表新增记录
     * */
    int addWage(List<Wage> wages);

    /**
     * 查询这个月工资是否已发放
     * */
    int checkWage(int id);

    /**
     * 查询当月工资列表
     * */
    List<Map<String,Object>> getWageList(int id);

    /**
     * 获取所有的工资列表
     * */
    List<Map<String,Object>> getAllWageList();
}
