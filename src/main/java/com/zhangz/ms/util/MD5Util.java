package com.zhangz.ms.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/11
 * @time: 22:48
 */
public class MD5Util {

    /**
     * 二次加盐生成数据库加密密码
     * @param inputPass
     * @param saltDB
     * @return
     */
    public static String inputPasToDBPass(String inputPass,String saltDB){
        String formPass = inputPassFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }


    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    /**
     *  加盐实现md5加密
     */
    private static final String salt = "1a2b3c4d";

    /**
     *  输入密码第一次加密
     * @param inputPass
     * @return
     */
    public static String inputPassFormPass(String inputPass){
        String str =   salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5);
        return md5(str);
    }



    /**
     *  第二次加密
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass,String salt){
        String str =   salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5);
        return md5(str);
    }

}
