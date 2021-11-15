package com.zhangz.ms.redis;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/11
 * @time: 22:01
 */
public abstract class BasePrefix implements KeyPrefix {
    private int expireSeconds;
    private String prefix;


    public BasePrefix(String prefix) {
        this.expireSeconds = 0;
        this.prefix = prefix;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {// 默认0 ，永不过期
        return expireSeconds;
    }

    @Override
    public String getPreFix() {
        String simpleName = getClass().getSimpleName();
        return simpleName + ":" + prefix;
    }
}
