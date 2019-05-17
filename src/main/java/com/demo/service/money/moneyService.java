package com.demo.service.money;

import com.demo.dao.moneyMapper;
import com.demo.domain.department.Department;
import com.demo.domain.wage.Reward;
import com.demo.domain.wage.Wage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 千城暮雪
 * @DATE： 2019/4/5 13:09
 * @Version 1.0.0
 */
@Service
public class moneyService {

    @Autowired
    private moneyMapper mapper;
    /**
     * 根据id查找部门信息
     * */
    public Map<String,Object> selectDepartment(int id){return mapper.selectDepartment(id); }

    /**
     * 更新部门底薪
     * */
    public int updateBasicSalary(Department department){return mapper.updateBasicSalary(department);}

    /**
     * 增加奖惩记录
     * */
    public int addReward(Reward reward){return mapper.addReward(reward);}

    /**
     * 查看本月出勤天数
     * */
    public int countAttendanceBY(int id){return mapper.countAttendanceBY(id);}

    /**
     * 查看上月出勤天数
     * */
    public int countAttendanceSY(int id){return mapper.countAttendanceSY(id);}
    /**
     * 查询某部门的所有员工id
     * */
    public List<Map<String,Integer>> selectEmployeeID(int id){return mapper.selectEmployeeID(id);}

    /**
     * 查找部门底薪
     * */
    public int selectBasicSalary(int id){return mapper.selectBasicSalary(id);}

    /**
     * 查询员工奖惩
     * */
    public List<Map<String,Integer>> selectRewards(int id){return mapper.selectRewards(id);}

    /**
     * 查询员工本月加班天数
     * */
    public int selectOverTime(int id){return mapper.selectOverTime(id);}

    /**
     * 工资表新增记录
     * */
    public int addWage(List<Wage> wages){return mapper.addWage(wages);}

    /**
     * 查询这个月工资是否已发放
     * */
    public int checkWage(int id){return mapper.checkWage(id);}

    /**
     * 查询当月工资列表
     * */
    public List<Map<String,Object>> getWageList(int id){return mapper.getWageList(id);}
    /**
     * 获取所有的工资列表
     * */
    public List<Map<String,Object>> getAllWageList(){return mapper.getAllWageList();}
}
