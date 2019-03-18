package com.demo.domain.overtime;

public class updateApprove {

    private int overtimeID;
    private String approve;
    private Boolean status;

    public int getOvertimeID() {
        return overtimeID;
    }

    public void setOvertimeID(int overtimeID) {
        this.overtimeID = overtimeID;
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
        return "updateApprove{" +
                "overtimeID=" + overtimeID +
                ", approve='" + approve + '\'' +
                ", status=" + status +
                '}';
    }
}
