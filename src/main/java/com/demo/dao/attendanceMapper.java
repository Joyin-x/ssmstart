package com.demo.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author wwx
 * @date 2019/1/29 15:29
 **/
@Mapper
public interface attendanceMapper {
    /**
     * 增加考勤记录
     * */
    public int addAttendande();
}
