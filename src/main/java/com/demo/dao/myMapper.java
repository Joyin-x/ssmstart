package com.demo.dao;

import com.demo.domain.Image;
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
}
