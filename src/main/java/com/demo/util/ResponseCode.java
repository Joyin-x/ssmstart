package com.demo.util;

/**
 * @author wwx
 * @date 2018/12/27 11:07
 **/

/**
 * 定义响应的状态码
 */
public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),
    ERROR(404, "ERROR"),
    NEED_LOG(1, "NEED_LOG"),
    SERVER_ERROR(500,"服务器出错");



    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}