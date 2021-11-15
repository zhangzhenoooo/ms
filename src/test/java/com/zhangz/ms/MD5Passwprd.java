package com.zhangz.ms;

import com.zhangz.ms.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/13
 * @time: 14:20
 */
@SpringBootTest
public class MD5Passwprd {
    @Test
    public void testLoginCheckPassword(){
        String password1 = "123456789";
        String pasToDBPass1 = MD5Util.inputPasToDBPass(password1, "abc");
        String password2 = "123456789";
        String pasToDBPass2 = MD5Util.inputPasToDBPass(password2, "abc");
        System.out.println(pasToDBPass1.equals(pasToDBPass2));
    }
}
