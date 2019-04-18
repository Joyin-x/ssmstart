package com.demo.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 千城暮雪
 * @DATE： 2019/4/15 21:32
 * @Version 1.0.0
 */
public class SendMsgUtil {
    private static final String GET = "get";

    /**
     * 发送短信消息
     *
     * @param url        请求地址
     * @param accountSid 开发者主账号ID
     * @param authToken  开发者主账号 TOKEN
     * @param content    短信内容，和模板保持一致
     * @param method     请求模式，get或者post
     * @param phones     短信接收端手机号码，可多个号码
     * @return String    请求结果
     */
    public static String sendMsg(String url, String accountSid, String authToken, String content, String method, String... phones) {
        //如果是get请求，对请求中文加上编码，防止中文乱码
        if (method.equalsIgnoreCase(GET)) {
            try {
                content = java.net.URLEncoder.encode(content, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //可以多个手机号，用，号拼接起来
        String phone = "";
        for (String data : phones) {
            phone += data + ",";
        }
        phone.substring(0, phone.lastIndexOf(","));
        //秒嘀API需要的接口参数
        Map<String, String> params = new HashMap<>(16);
        params.put("accountSid", accountSid);
        params.put("smsContent", content);
        params.put("to", phone);
        params.put("sig", queryArguments(accountSid, authToken));
        params.put("timestamp", getTimestamp());
        //调用Http工具类
        return HttpClientUtil.method(url, params, method);
    }

    /**
     * 随机生成6位随机验证码
     *
     * @return 验证码
     */
    public static String getRandNum() {
        String randNum = new Random().nextInt(1000000) + "";
        //如果生成的不是6位数随机数则返回该方法继续生成
        int num = 6;
        if (randNum.length() != num) {
            return getRandNum();
        }
        return randNum;
    }

    /**
     * @return 获取时间戳
     */
    public static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }
    /**
     * 签名，MD5(sid + token+ timestamp)，共32位（小写）
     * 注意：MD5中的内容不包含”+”号。
     *
     * @param accountSid
     * @param authToken
     * @return
     */
    public static String queryArguments(String accountSid, String authToken) {
        //时间戳
        String timestamp = getTimestamp();
        //签名认证
        String sig = getMD5(accountSid, authToken, timestamp);
        return sig;
    }
    /**
     * MD5加密
     *
     * @param args 动态参数
     * @return
     */
    public static String getMD5(String... args) {
        StringBuffer result = new StringBuffer();
        if (args == null || args.length == 0) {
            return "";
        } else {
            StringBuffer str = new StringBuffer();
            for (String string : args) {
                str.append(string);
            }
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] bytes = digest.digest(str.toString().getBytes());
                for (byte b : bytes) {
                    //转化十六进制
                    String hex = Integer.toHexString(b & 0xff);
                    if (hex.length() == 1) {
                        result.append("0" + hex);
                    } else {
                        result.append(hex);
                    }
                }

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
