package com.zhangz.ms.service;

import com.zhangz.ms.common.CodeMsg;
import com.zhangz.ms.domain.MiaoShaUser;
import com.zhangz.ms.vo.LoginVO;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/9
 * @time: 23:22
 */
public interface MiaoShaUserService {
    MiaoShaUser getUserById(int id);

    boolean testSw();

    MiaoShaUser getUserByNickName(String nickname);

    boolean login(LoginVO loginVO);
}
