package com.zhangz.ms.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/10
 * @time: 22:23
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    public JedisPool jedisPool;

    @Autowired
    public RedisConfig redisConfig;

    @Override
    public <T> T get(KeyPrefix prefix,String key, Class clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPreFix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str,clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    @Override
    public <T> boolean  set(KeyPrefix prefix,String key,T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPreFix() + key;
            int expireSeconds = prefix.expireSeconds();
            if (expireSeconds <= 0 ){
                jedis.set(realKey, beanToString(value));
            }else {
                jedis.setex(realKey, expireSeconds, beanToString(value));
            }
            return true;
        }finally {
            returnToPool(jedis);
        }
    }


    public <T> T incr(KeyPrefix prefix,String key, Class clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPreFix() + key;
            jedis.incr(realKey);
            String str = jedis.get(realKey);
            T t = stringToBean(str,clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> T decr(KeyPrefix prefix,String key, Class clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPreFix() + key;
            jedis.decr(realKey);
            String str = jedis.get(realKey);
            T t = stringToBean(str,clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }













    private <T> T stringToBean(String str, Class clazz) {
        if (null == str || str.length() <=0 || null == clazz){
            return null;
        }
        if (int.class == clazz || Integer.class == clazz){
            return (T) Integer.valueOf(str);
        }
        if (long.class == clazz || Long.class == clazz){
            return (T) Long.valueOf(str);
        }
        if (String.class == clazz){
            return (T) str;
        }else {
            return (T) JSON.toJavaObject(JSON.parseObject(str),clazz);
        }

    }
    private <T> String beanToString(T value) {
        if (null == value){
            return null;
        }
        Class<?> tClass = value.getClass();
        if (int.class == tClass || Integer.class == tClass){
            return (""+value);
        }
        if (long.class == tClass || Long.class == tClass){
            return (""+value);
        }
        if (String.class == value){
            return (String) value;
        }else {
            return (String) JSON.toJSONString(value);
        }

    }
    private void returnToPool(Jedis jedis) {
        if (null != jedis){
            /**
             *  f返回到连接池中
             */
            jedis.close();
        }
    }


}
