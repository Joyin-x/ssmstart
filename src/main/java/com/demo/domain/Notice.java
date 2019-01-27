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
    private String name;
    private String header;
    private String content;
    private Date noticeTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
