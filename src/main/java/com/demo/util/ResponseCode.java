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
    NEED_LOG(410,"请先登录"),
    SERVER_ERROR(500,"请求出错"),
    notAttendance(411,"请勿重复打卡"),
    PAY_MONEY(412,"发放失败，该部门工资已经发放");
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }


    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}