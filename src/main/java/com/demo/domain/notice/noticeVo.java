package com.demo.domain.notice;

import java.util.Date;

/**
 * @author wwx
 * @date 2019/2/12 16:05
 **/
public class noticeVo {
    private int id;
    private String header;
    private String content;
    private String noticeTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }
}
