package com.demo.dao;

import com.demo.domain.department.Department;
import com.demo.domain.mobilize.Mobilize;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.department.DepartmentAndId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wwx
 * @date 2019/1/28 16:10
 **/
@Mapper
public interface departmentMapper {
    /**
     * 增加部门信息
     * */
    public int addDepartment(Department department);

    /**
     * 修改部门信息
     * */
    public int modifyDepartment(Department department);

    /**
     * 刪除部門信息
     * */
    public int deleteDepartment(int id);

    /**
     * 根据搜索框内容返回员工部门和职务
     * */
    public List<DepartmentAndEmployee> searchDepartmentByID(String text);
    public List<DepartmentAndEmployee> searchDepartmentByName(String text);
    public List<DepartmentAndEmployee> searchDepartmentByDname(String text);
    public List<DepartmentAndEmployee> searchDepartmentByPosition(String text);

    /**
     * 返回已经存在的部门和其id*/
    public List<DepartmentAndId> getDepartmentAndId();

    /**修改员工所在的部门和职务
     * */
    public int updateEmployee(Mobilize mobilize);

    /**
     * 新增工作调动记录
     * */
    public int addMobilze(Mobilize mobilize);
}
