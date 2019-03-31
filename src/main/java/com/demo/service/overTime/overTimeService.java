package com.demo.service.overTime;

import com.demo.dao.overTimeMapper;
import com.demo.domain.attendance.Attendance;
import com.demo.domain.attendance.updateAttendance;
import com.demo.domain.overtime.overTime;
import com.demo.domain.overtime.updateApprove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class overTimeService {

    @Autowired
    private overTimeMapper mapper;

    /**
     * 增加一条加班记录
     * */
    public int addOverTimeRecord(overTime overtime){return mapper.addOverTimeRecord(overtime);}

    /**
     * 根据部门id查询未审批的加班记录
     * */
    public List<Map<String,Object>> getNotApprove(int id){return mapper.getNotApprove(id);}


    /**
     * 根据部门id查询未审批的加班记录
     * */
    public List<Map<String,Object>> getApprove(int id){return mapper.getApprove(id);}


    /**
     * 更新加班审批记录
     * */
    public int approve(updateApprove update){return mapper.approve(update);}

    /**
     * 新增考勤记录
     * */
    public int addAttendance(Attendance attendance){return mapper.addAttendance(attendance);}

    /**
     * 查询当天考勤记录
     * */
    public int getAttendance(int id){return mapper.getAttendance(id);}

    /**
     * 更新员工下班考勤记录
     * */
    public int updateAttendance(updateAttendance updateattendance){return mapper.updateAttendance(updateattendance);}

    /**
     * 查询当天早上是否已签到
     * */
    public int isAttendance(int employeeID){return mapper.isAttendance(employeeID);}


    /**
     * 查询当天下午是否已签到
     * */
    public int isAttendancePM(int id){return mapper.isAttendancePM(id);}

    /**
     * 根据部门查询当前打卡记录
     * */
    public List<Map<String,Object>> getAttendanceById(int id){return mapper.getAttendanceById(id);}

    /**
     * 查询打卡排行记录
     * */
    public List<Map<String,Object>> getRankList(){return mapper.getRankList();}
}
