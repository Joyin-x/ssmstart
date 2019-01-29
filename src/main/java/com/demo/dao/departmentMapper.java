package com.demo.dao;

import com.demo.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wwx
 * @date 2019/1/28 16:10
 **/
@Mapper
public interface departmentMapper {
    /**
     * 增加部门信息*/
    public int addDepartment(Department department);

    /**
     * 修改部门信息
     * */
    public int modifyDepartment(Department department);

    /**
     * 刪除部門信息
     * */
    public int deleteDepartment(int id);
}
