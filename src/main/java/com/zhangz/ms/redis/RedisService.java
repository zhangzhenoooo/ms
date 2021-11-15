package com.zhangz.ms.redis;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/10
 * @time: 22:22
 */
public interface RedisService {
    <T> T get(KeyPrefix prefix,String key, Class clazz);

    <T> boolean set(KeyPrefix prefix,String keyq, T value);

 }
