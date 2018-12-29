package com.demo.domain.department;

import com.demo.domain.Employee;

import java.util.List;

/**
 * @author wwx
 * @date 2018/12/29 14:52
 **/
public class DepartmentAndEmployee {
    private String departmentName;
    private List<Employee> employeeList;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
