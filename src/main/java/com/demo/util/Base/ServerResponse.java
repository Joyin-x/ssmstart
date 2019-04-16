package com.demo.util.Base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwx
 * @date 2018/12/27 11:01
 **/
//序列化json情况时，过滤掉值为null的字段
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {

    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    /*
    * 操作成功时，返回数据
    *   @param statu
    *   @param data
    *   @param msg
    * */

    public void setStatus(ResponseCode response){
        this.code=response.getCode();
        this.msg=response.getMsg();
    }
    public ServerResponse(){
        this.code= ResponseCode.ERROR.getCode();
        this.msg=ResponseCode.ERROR.getMsg();
    }
    public ServerResponse(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /*
     * 操作失败时，不返回数据
     *   @param statu
     *   @param msg
     * */

    public ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //告诉 Jackson 在处理时忽略该注解标注的属性，使之不在序列化结果中
    @JsonIgnore
    public boolean checkIsSuccess(){
        return this.code==ResponseCode.SUCCESS.getCode();
    }

    /**
     * 成功返回数据
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,msg);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }


    /**
     * 返回错误信息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServerResponse<T> createByNeedLogin(){
        return new ServerResponse<T>(ResponseCode.NEED_LOG.getCode(),"请先登录！");
    }

    public static <T> ServerResponse<T> createByServerError(){
        return new ServerResponse<T>(ResponseCode.SERVER_ERROR.getCode(),ResponseCode.SERVER_ERROR.getMsg());
    }
}
