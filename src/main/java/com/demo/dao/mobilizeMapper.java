package com.demo.dao;

import com.demo.domain.task.Task;
import com.demo.domain.mobilize.MobilizeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/2/14 9:45
 **/
@Mapper
public interface mobilizeMapper {
    /**
     * 返回工作调动记录
     * */
    List<MobilizeRecord> getAllMobilize();

    /**
     * 返回工作调动记录表中的员工岗位记录姓名和id
     * */
    List<Map<String,Object>> getMobilizeWithName();

    /**
     * 根据员工id返回该员工的工作变动记录*/
    List<Map<String,Object>> getMobilizeWithId(int id);

    /**
     * 员工指派任务
     * */
    int addTask(Task task);

    /**
     * 获取指派任务列表
     * */
    List<Map<String,Object>> getTaskList();


    /**
     * 删除员工调动记录*/
    int deleteMobilize(int id);
}
