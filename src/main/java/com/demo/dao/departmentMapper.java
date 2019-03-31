package com.demo.dao;

import com.demo.domain.department.Department;
import com.demo.domain.mobilize.Mobilize;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.department.DepartmentAndId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author wwx
 * @date 2019/1/28 16:10
 **/
@Mapper
public interface departmentMapper {
    /**
     * 增加部门信息
     * */
    int addDepartment(Department department);

    /**
     * 修改部门信息
     * */
    int modifyDepartment(Department department);


    /**
     * 查找要删除部门的所有员工信息*/
    List<Integer> getDeleteDepartmentEmployee(int id);
    /**
     * 删除部门时删除其他表中的员工信息*/
    int deleteDepartmentAllEmployee(List<Integer> list);
    /**
     *刪除部門信息
     * */
    int deleteDepartment(int id);

    /**
     * 根据搜索框内容返回员工部门和职务
     * */
    List<DepartmentAndEmployee> searchDepartmentByID(String text);
    List<DepartmentAndEmployee> searchDepartmentByName(String text);
    List<DepartmentAndEmployee> searchDepartmentByDname(String text);
    List<DepartmentAndEmployee> searchDepartmentByPosition(String text);

    /**
     * 返回已经存在的部门和其id*/
    List<DepartmentAndId> getDepartmentAndId();

    /**修改员工所在的部门和职务
     * */
    int updateEmployee(Mobilize mobilize);

    /**
     * 新增工作调动记录
     * */
    int addMobilze(Mobilize mobilize);

    /**
     * 返回查询到的普通员工姓名和id*/
    List<Map<String,Object>> getSimpleEmployee();

    /**
     * 根据负责人id查找部门id
     * */
    int getDepartmentID(int id);

}
