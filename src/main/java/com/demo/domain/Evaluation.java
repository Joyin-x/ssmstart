package com.demo.domain;

import java.util.Date;

/**
 * @author wwx
 * @date 2018/12/28 10:52
 **/
public class Evaluation {
    private int id;
    private int employee_id;
    private String evaluation_content;
    private Date evaluation_time;
    private String evaluation_level;
    private String certificate;
    private String remark;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEvaluation_content() {
        return evaluation_content;
    }

    public void setEvaluation_content(String evaluation_content) {
        this.evaluation_content = evaluation_content;
    }

    public Date getEvaluation_time() {
        return evaluation_time;
    }

    public void setEvaluation_time(Date evaluation_time) {
        this.evaluation_time = evaluation_time;
    }

    public String getEvaluation_level() {
        return evaluation_level;
    }

    public void setEvaluation_level(String evaluation_level) {
        this.evaluation_level = evaluation_level;
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
