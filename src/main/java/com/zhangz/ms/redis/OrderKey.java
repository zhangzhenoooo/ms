package com.zhangz.ms.redis;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/11
 * @time: 22:04
 */
public class OrderKey extends BasePrefix {
    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
