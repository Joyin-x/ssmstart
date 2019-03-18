package com.demo.dao;

import com.demo.domain.Image;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wwx
 * @date 2019/3/1 17:44
 **/

@Mapper
public interface myMapper {

    //根据id获取我的任务清单
    public List<MappingChange.Map<String,Object>> getTaskById(int id);

    //存储用户头像
    public int addImage(Image image);
}
