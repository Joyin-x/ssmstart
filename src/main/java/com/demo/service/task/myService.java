package com.demo.service.task;

import com.demo.dao.myMapper;
import com.demo.domain.Image;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/3/1 17:46
 **/
@Service
public class myService {
    @Autowired
    private myMapper mapper;

    //根据id获取我的任务清单
    public List<Map<String, Object>> getTaskById(int id) {
        return mapper.getTaskById(id);
    }

    //存储头像
    public int addImage(Image image) {
        return mapper.addImage(image);
    }

    //返回我的工作调动记录
    public List<Map<String,Object>> getMyMobilizeList(int id){return mapper.getMyMobilizeList(id);}

    //返回我的加班申请
    public List<Map<String,Object>> getMyOvertimeList(int id){return mapper.getMyOvertimeList(id);}

    //返回我的工资单记录
    public List<Map<String,Object>> getMyMoneyList(int id){return mapper.getMyMoneyList(id);}

    //根据部门id查找部门名字
    public String  getDepartmentName(int id){return mapper.getDepartmentName(id);}

    //修改我的任务状态
    public int updateTaskStatus(int id){return mapper.updateTaskStatus(id);}
}
