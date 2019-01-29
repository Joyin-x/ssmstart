package com.demo.domain.attendance;

import java.util.Date;

/**
 * @author wwx
 * @date 2019/1/29 15:28
 **/
public class Attendance {
    private int id;
    private int employeeId;
    private Date officeTime;
    private Date afterWork;

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

    public Date getOfficeTime() {
        return officeTime;
    }

    public void setOfficeTime(Date officeTime) {
        this.officeTime = officeTime;
    }

    public Date getAfterWork() {
        return afterWork;
    }

    public void setAfterWork(Date afterWork) {
        this.afterWork = afterWork;
    }
}
