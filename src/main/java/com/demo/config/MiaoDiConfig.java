package com.demo.config;


import com.demo.util.SendMsgUtil;

/**
 * @author wwx
 * @date 2019/4/12 17:31
 **/
public class MiaoDiConfig {
    /**
     * url前半部分
     */
    public static final String BASE_URL="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    /**
     * 开发者注册后系统自动生成的账号，可在官网登录后查看
     */
    public static final String ACCOUNT_SID="030b3e1702c948fc931c7f3c8f5667cf";

    public static final String num=SendMsgUtil.getRandNum();
    /**
     * 开发者注册后系统自动生成的TOKEN，可在官网登录后查看
     */
    public static final String AUTH_TOKEN="7397a1efddcd4c3bb6b7d11c7f30c823";

    /**
     * 短信模板内容
     */
    public static final String smsContent="【昊天科技】您的验证码为" + num + "，请于" + 5 + "分钟内正确输入，如非本人操作，请忽略此短信。";
    /**
     * 响应数据类型, JSON或XML
     */
    public static final String RESP_DATA_TYPE = "json";
}
