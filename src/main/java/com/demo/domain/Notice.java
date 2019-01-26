package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @author wwx
 * @date 2019/1/26 16:49
 **/
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Notice {
    private int id;
    private int employeeId;
    private String header;
    private String content;
    private Date noticeTime;

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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }
}
