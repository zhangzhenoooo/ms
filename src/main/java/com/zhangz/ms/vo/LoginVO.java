package com.zhangz.ms.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/14
 * @time: 22:12
 */
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    @NotNull
    private String nickname;
    @NotNull
    @Length(min = 6,message = "密码长度不能小于6位")
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
