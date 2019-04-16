package com.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.redis.RedisCacheStorage;
import com.demo.util.Base.ResponseCode;
import com.demo.util.Base.ServerResponse;
import com.demo.util.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
@Controller
@ResponseBody

public class PostCodeController {


    @Autowired
    public RedisCacheStorage<String,Object> redisCacheStorage;

    Jedis jedis = new Jedis("127.0.0.1");
    //发送请求到微信服务器换取用户唯一标识 OpenID 和 会话密钥 session_key
    public static JSONObject sendPost(String URLParam) {

        JSONObject backJSON=null;
        try {
            final String ADD_URL = URLParam;
            //创建连接
            URL url = new URL(ADD_URL);//创建java url对象
            HttpsURLConnection connection = (HttpsURLConnection) url
                    .openConnection();//创建该对象的https请求
            connection.setDoOutput(true);//设置请求允许向对方服务器传输
            connection.setDoInput(true);//设置请求允许己方接收传输
            connection.setRequestMethod("POST");//设置传输方式POST
            connection.setUseCaches(false);//POST请求不允许设置缓存
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.connect();//建立链接

            //POST请求
            DataOutputStream out = new DataOutputStream(
                    connection.getOutputStream());

            // out.write(obj.toString().getBytes("UTF-8"));//传输中文需要标明转码格式
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));//接收流
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "ASCII");
                sb.append(lines);
            }//读取返回的数据
            reader.close();
            // 断开连接
            connection.disconnect();
            backJSON=JSONObject.parseObject(sb.toString());
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return backJSON;
    }


    //接受前台发过来的code
    @RequestMapping("/returnUUID")
    public ServerResponse checkCode(String code){
        ServerResponse response=new ServerResponse();
        //如果传过来的code为null或者空，则返回失败
       if(code==null||code.length()==0){
        response.setMsg("code不能为空");
       }else{
           String appid = "wxacb6b666b96f99cb";
           String secret = "4c2b7732fb9e6ac73fcc82ab56b6370e";
           String URLParam="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+""
                   + "&secret="+secret+"&js_code="+code;

           //发送 GET 请求
           //System.out.println(authURL);
           JSONObject backJSON = PostCodeController.sendPost(URLParam);
           System.out.println("backJson:"+backJSON);
           if(backJSON!=null){
               //生成随机的32位uuid
               String uuid=UUIDTool.getUUID();
               response.setStatus(ResponseCode.SUCCESS);
               jedis.set(uuid,backJSON.get("openid").toString()+"."+backJSON.get("session_key").toString());
//               Cache cache=new Cache();
//               cache.setUUID(uuid);
//               cache.setValue(backJSON.get("openid").toString()+"."+backJSON.get("session_key").toString());
//               System.out.println(cache);
//               redisCacheStorage.set("1",cache);
               System.out.println("存储uuid:"+uuid);
               response.setData(uuid);
           }
       }

        return response;
    }

    //接受前台发过来的code
    @RequestMapping("/checkCUUID")
    public void getSessionKey(String uuid){
        System.out.println("上传uuid："+uuid);
        System.out.println("获取uuid里的值："+jedis.get(uuid));
    }

}
