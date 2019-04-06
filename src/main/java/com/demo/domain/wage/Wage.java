package com.demo.domain.wage;


import java.sql.Date;

/**
 * @author wwx
 * @date 2019/2/12 17:36
 * 工资表
 **/
public class Wage {
    private int id;
    private int employeeId;
    private float basicSalary;
    private float bonus;
    private float overtimePay;
    private float netPayroll;
    private String startTime;
    private String endTime;
    private String payDate;

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

    public float getBasicSalsry() {
        return basicSalary;
    }

    public void setBasicSalsry(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(float overtimePay) {
        this.overtimePay = overtimePay;
    }

    public float getNetPayroll() {
        return netPayroll;
    }

    public void setNetPayroll(float netPayroll) {
        this.netPayroll = netPayroll;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", basicSalsry=" + basicSalary +
                ", bonus=" + bonus +
                ", overtimePay=" + overtimePay +
                ", netPayroll=" + netPayroll +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", payDate=" + payDate +
                '}';
    }
}
