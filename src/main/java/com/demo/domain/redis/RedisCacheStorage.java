package com.demo.domain.redis;

import java.util.Map;

/**
 * Created by ${HeJD} on 2018/6/29.
 */
public interface RedisCacheStorage<K,V> {

    /**
     * 在redis数据库中插入 key  和value
     * @param key
     * @param value
     * @return
     */
    boolean set(K key,V value);
    /**
     * 在redis数据库中插入 key  和value 并且设置过期时间
     * @param key
     * @param value
     * @param exp 过期时间
     * @return
     */
    boolean set(K key, V value, int exp);
    /**
     * 根据key 去redis 中获取value
     * @param key
     * @return
     */
    V get(K key,Object object);
    /**
     * 删除redis库中的数据
     * @param key
     * @return
     */
    boolean remove(K key);
    /**
     * 设置哈希类型数据到redis 数据库
     * @param cacheKey 可以看做一张表
     * @param key   表字段
     * @param value
     * @return
     */
    boolean hset(String cacheKey,K key,V value);
    /**
     * 获取哈希表数据类型的值
     * @param cacheKey
     * @param key
     * @return
     */
    V hget(String cacheKey,K key,Object object);
    /**
     * 获取哈希类型的数据
     * @param cacheKey
     * @return
     */
    Map<K,V> hget(String cacheKey,Object object);
}
