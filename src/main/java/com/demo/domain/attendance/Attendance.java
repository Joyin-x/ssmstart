package com.demo.domain.attendance;

import java.util.Date;

/**
 * @author wwx
 * @date 2019/1/29 15:28
 **/
public class Attendance {
    private int id;
    private int employeeID;
    private String officeTime;
    private  String afterWork;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getOfficeTime() {
        return officeTime;
    }

    public void setOfficeTime(String officeTime) {
        this.officeTime = officeTime;
    }

    public String getAfterWork() {
        return afterWork;
    }

    public void setAfterWork(String afterWork) {
        this.afterWork = afterWork;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", employeeID=" + employeeID +
                ", officeTime='" + officeTime + '\'' +
                ", afterWork='" + afterWork + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
