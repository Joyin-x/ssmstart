package com.demo.domain.mobilize;

/**
 * @author wwx
 * @date 2019/2/13 14:09
 **/
public class Mobilize {
    private int employeeId;
    private String originalPosition;
    private int originalDepartmentId;
    private String nowPosition;
    private int nowDepartmentId;
    private String transferDate;
    private String transferReason;
    private String approver;
    private String mobilizeRemark;

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(String originalPosition) {
        this.originalPosition = originalPosition;
    }

    public int getOriginalDepartmentId() {
        return originalDepartmentId;
    }

    public void setOriginalDepartmentId(int originalDepartmentId) {
        this.originalDepartmentId = originalDepartmentId;
    }

    public String getNowPosition() {
        return nowPosition;
    }

    public void setNowPosition(String nowPosition) {
        this.nowPosition = nowPosition;
    }

    public int getNowDepartmentId() {
        return nowDepartmentId;
    }

    public void setNowDepartmentId(int nowDepartmentId) {
        this.nowDepartmentId = nowDepartmentId;
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getMobilizeRemark() {
        return mobilizeRemark;
    }

    public void setMobilizeRemark(String mobilizeRemark) {
        this.mobilizeRemark = mobilizeRemark;
    }
}
