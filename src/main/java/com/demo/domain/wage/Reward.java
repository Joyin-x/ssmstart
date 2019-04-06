package com.demo.domain.wage;

import java.util.Date;

/**
 * @Author: 千城暮雪
 * @DATE： 2019/4/5 21:02
 * @Version 1.0.0
 */
public class Reward {
    private int id;
    private int employeeId;
    private Date rewardsDate;
    private int money;
    private String rewardsReason;

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

    public Date getRewardsDate() {
        return rewardsDate;
    }

    public void setRewardsDate(Date rewardsDate) {
        this.rewardsDate = rewardsDate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getRewardsReason() {
        return rewardsReason;
    }

    public void setRewardsReason(String rewardsReason) {
        this.rewardsReason = rewardsReason;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", rewardsDate=" + rewardsDate +
                ", money=" + money +
                ", rewardsReason='" + rewardsReason + '\'' +
                '}';
    }
}
