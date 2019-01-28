package com.demo.service.department;

import com.demo.dao.departmentMapper;
import com.demo.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wwx
 * @date 2019/1/28 16:13
 **/
@Service
public class departmentService {
    @Autowired
    private departmentMapper mapper;


    /**
     * 增加新部门
     * */
    public int addDepartment(Department department){
        return mapper.addDepartment(department);
    }

    /**
     * 修改部门信息*/
    public int modifyDepartment(Department department){return mapper.modifyDepartment(department);}

}
