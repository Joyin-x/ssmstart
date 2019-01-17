package com.demo.util;

/**
 * @author wwx
 * @date 2018/12/27 11:07
 **/

/**
 * 定义响应的状态码
 */
public enum ResponseCode {
    SUCCESS(200, "成功"),
    ERROR(420, "失败"),
    NOT_FOUND(404, "请求不存在"),
    NEED_LOG(410,"请先登录"),
    SERVER_ERROR(500,"请求出错");



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