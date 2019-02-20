package com.demo.service.mobilize;

import com.demo.dao.mobilizeMapper;
import com.demo.domain.Task;
import com.demo.domain.mobilize.MobilizeRecord;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/2/14 9:47
 **/
@Service
public class MobilizeService {
    @Autowired
    private mobilizeMapper mapper;


    /**
     * 返回工作调动记录
     * */
    public List<MobilizeRecord> getAllMobilize(){return mapper.getAllMobilize();}

    /**
     * 返回工作调动记录表中的员工岗位记录姓名和id
     * */
    public List<Map<String,Object>> getMobilizeWithName(){return mapper.getMobilizeWithName();}

    /**
     * 根据员工id返回该员工的工作变动记录*/
    public List<Map<String,Object>> getMobilizeWithId(int id){return mapper.getMobilizeWithId(id);}

    /**
     * 给员工指派任务*/
    public int addTask(Task task){return mapper.addTask(task);}

    /**
     * 获取任务指派记录
     * */
    public List<Map<String,Object>> getTaskList(){return mapper.getTaskList();}
}
