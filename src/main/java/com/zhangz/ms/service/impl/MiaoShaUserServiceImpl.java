package com.zhangz.ms.service.impl;

import com.zhangz.ms.common.CodeMsg;
import com.zhangz.ms.dao.UserMapper;
import com.zhangz.ms.domain.MiaoShaUser;
import com.zhangz.ms.exception.GlobalException;
import com.zhangz.ms.service.MiaoShaUserService;
import com.zhangz.ms.util.MD5Util;
import com.zhangz.ms.vo.LoginVO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/9
 * @time: 23:23
 */
@Service
public class MiaoShaUserServiceImpl implements MiaoShaUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public MiaoShaUser getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional
    public boolean testSw() {
        MiaoShaUser miaoShaUser1 = new MiaoShaUser();
        miaoShaUser1.setId("5");
        miaoShaUser1.setNickname("zhangz");
        userMapper.inser(miaoShaUser1);
        MiaoShaUser miaoShaUser2 = new MiaoShaUser();
        miaoShaUser2.setId("1");
        miaoShaUser2.setNickname("zhangsan");
        userMapper.inser(miaoShaUser2);
        return true;
    }

    @Override
    public MiaoShaUser getUserByNickName(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    @Override
    public boolean login(LoginVO loginVO) {
        MiaoShaUser u =   userMapper.getUserByNickname(loginVO.getNickname());
        if (ObjectUtils.isEmpty(u))    throw  new GlobalException(CodeMsg.USER_NOT_FOUND);
        //校验用户名密码
        String needCheckPass = MD5Util.inputPasToDBPass(loginVO.getPassword(), u.getSalt());
        if (!needCheckPass.endsWith(u.getPassword())){
            throw  new GlobalException(CodeMsg.USER_NICKNAME_OR_PASS_ERROR);
         }
        // 验证通过
        return true;
    }
}
