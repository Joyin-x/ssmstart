package com.demo.service.department;

import com.demo.dao.departmentMapper;
import com.demo.domain.Department;
import com.demo.domain.Mobilize;
import com.demo.domain.department.DepartmentAndEmployee;
import com.demo.domain.department.DepartmentAndId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 删除部门信息*/
    public int deleteDepartment(int id){return mapper.deleteDepartment(id);}
    /**
     * 根据搜索框内容返回员工部门和职务
     * */
    public List<DepartmentAndEmployee> searchDepartmentByID(String text){return mapper.searchDepartmentByID(text);}
    public List<DepartmentAndEmployee> searchDepartmentByName(String text){return mapper.searchDepartmentByName(text);}
    public List<DepartmentAndEmployee> searchDepartmentByDname(String text){return mapper.searchDepartmentByDname(text);}
    public List<DepartmentAndEmployee> searchDepartmentByPosition(String text){return mapper.searchDepartmentByPosition(text);}

    /**
     * 返回已经存在的部门和其id*/
    public List<DepartmentAndId> getDepartmentAndId(){return mapper.getDepartmentAndId();}

    /**修改员工所在部门和职务
     * */
    public int updateEmployee(Mobilize mobilize){return mapper.updateEmployee(mobilize);}

    /**
     * 新增工作调动记录
     * */
    public int addMobilze(Mobilize mobilize){return mapper.addMobilze(mobilize);}
}
