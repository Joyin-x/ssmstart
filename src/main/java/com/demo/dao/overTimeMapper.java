package com.demo.dao;

import com.demo.domain.attendance.Attendance;
import com.demo.domain.attendance.updateAttendance;
import com.demo.domain.overtime.overTime;
import com.demo.domain.overtime.updateApprove;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface overTimeMapper {

    /**
     * 增加一条加班记录
     */
    int addOverTimeRecord(overTime overtime);

    /**
     * 按部门id查询未审批的加班记录并返回
     */
    List<Map<String, Object>> getNotApprove(int id);


    /**
     * 按部门id查询未审批的加班记录并返回
     */

    List<Map<String, Object>> getApprove(int id);

    /**
     * 更新加班审批记录
     */
    int approve(updateApprove update);

    /**
     * 新增考勤记录
     */
    int addAttendance(Attendance attendance);

    /**
     * 查询当天考勤记录
     * */
    int getAttendance(int id);

    /**
     * 更新员工下班考勤记录
     * */
    int updateAttendance(updateAttendance updateattendance);

    /**
     * 查询当天早上是否已签到
     * */
    int isAttendance();

    /**
     * 查询当天下午是否已签到
     * */
    int isAttendancePM();

    /**
     * 根据部门查询当前打卡记录
     * */
    List<Map<String,Object>> getAttendanceById(int id);

    /**
     * 查询打卡排行记录
     * */
    List<Map<String,Object>> getRankList();

}
