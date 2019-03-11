package com.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Component
public class RedisUtil {
    /**
     * 日志记录
     * */
    private static final Logger Log= LoggerFactory.getLogger(RedisUtil.class);

    /**
     * redis连接池，这里jedisPool我们再之前spring配置中配置好了，交给spring管理
     * */
    @Autowired
    private JedisPool jedisPool;

    public void setPool(JedisPool jedisPool){
        this.jedisPool=jedisPool;
    }

    /**
     * 获取jedis
     * */
    public Jedis getResource(){
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
        }catch(Exception e){
            Log.info("can't get the redis resource");
        }
        return jedis;
    }


    /**
     * 关闭连接
     * */
    public void disconnect(Jedis jedis){
        jedis.disconnect();
    }

    /**
     * 将jedis返还连接池
     * */
    public void returnResource(Jedis jedis){
        if(null!=jedis){
            try{
                jedis.close();
            }catch(Exception e){
                Log.info("can't rerurn jedis to jedisPool");
            }
        }
    }

    /**
     * 无法返还jedispool，释放jedis客户端对象
     * */
    public void brokenResource(Jedis jedis){
        if (jedis!=null) {
            try {
                jedis.close();
            } catch (Exception e) {
                Log.info("can't release jedis Object");
            }
        }
    }
}
