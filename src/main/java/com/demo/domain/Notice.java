package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @author wwx
 * @date 2019/1/26 16:49
 **/
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Notice {
    private String header;
    private String content;
    private Date notice_time;

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

    public Date getNotice_time() {
        return notice_time;
    }

    public void setNotice_time(Date notice_time) {
        this.notice_time = notice_time;
    }
}
