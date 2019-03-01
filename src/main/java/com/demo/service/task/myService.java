package com.demo.service.task;

import com.demo.dao.myMapper;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wwx
 * @date 2019/3/1 17:46
 **/
@Service
public class myService {
    @Autowired
    private myMapper mapper;

    //根据id获取我的任务清单
    public List<MappingChange.Map<String,Object>> getTaskById(int id){
        return mapper.getTaskById(id);
    }
}
