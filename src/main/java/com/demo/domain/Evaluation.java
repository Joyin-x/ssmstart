package com.demo.domain;

import java.util.Date;

/**
 * @author wwx
 * @date 2018/12/28 10:52
 **/
public class Evaluation {
    private int id;
    private int employeeId;
    private String evaluationContent;
    private Date evaluationTime;
    private String evaluationLevel;
    private String certificate;
    private String remark;


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

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(String evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
