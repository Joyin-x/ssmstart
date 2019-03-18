package com.demo.domain.overtime;

public class overTime {
    private int overtimeID;
    private int id;
    private int departmentId;
    private String overTimeReason;
    private String startTime;
    private String endTime;
    private String approve;
    private Boolean status;


    public int getOvertimeID() {
        return overtimeID;
    }

    public void setOvertimeID(int overtimeID) {
        this.overtimeID = overtimeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getOverTimeReason() {
        return overTimeReason;
    }

    public void setOverTimeReason(String overTimeReason) {
        this.overTimeReason = overTimeReason;
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

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "overTime{" +
                "overtimeID=" + overtimeID +
                ", id=" + id +
                ", departmentId=" + departmentId +
                ", overTimeReason='" + overTimeReason + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", approve='" + approve + '\'' +
                ", status=" + status +
                '}';
    }
}
