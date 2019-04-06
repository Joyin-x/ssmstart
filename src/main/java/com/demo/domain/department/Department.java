package com.demo.domain.department;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwx
 * @date 2018/12/28 10:58
 **/

@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Department {

    private int id;
    private int employeeId;
    private String departmentName;
    private String principal;
    private String description;
    private String position;
    private String establishedTime;
        private int basicSalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEstablishedTime() {
        return establishedTime;
    }

    public void setEstablishedTime(String establishedTime) {
        this.establishedTime = establishedTime;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", departmentName='" + departmentName + '\'' +
                ", principal='" + principal + '\'' +
                ", description='" + description + '\'' +
                ", position='" + position + '\'' +
                ", establishedTime='" + establishedTime + '\'' +
                ", basicSalary='" + basicSalary + '\'' +
                '}';
    }
}
