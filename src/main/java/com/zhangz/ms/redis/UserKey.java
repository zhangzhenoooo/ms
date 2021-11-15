package com.zhangz.ms.redis;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/11
 * @time: 22:04
 */
public class UserKey extends BasePrefix {

    public UserKey(int expireSeconds, String prefix) {
        super(0, prefix);
    }

    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");

}
