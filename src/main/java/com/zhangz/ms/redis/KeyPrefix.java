package com.zhangz.ms.redis;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/11
 * @time: 22:00
 */
public interface KeyPrefix {
    int expireSeconds();
    String getPreFix();
}
