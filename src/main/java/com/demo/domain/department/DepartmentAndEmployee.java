package com.demo.domain.department;

import com.demo.domain.employee.Employee;

import java.util.List;

/**
 * @author wwx
 * @date 2018/12/29 14:52
 **/
public class DepartmentAndEmployee {

    private int id;
    private String departmentName;
    private String principal;

    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
