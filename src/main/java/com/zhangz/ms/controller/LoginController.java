package com.zhangz.ms.controller;

import com.zhangz.ms.common.CodeMsg;
import com.zhangz.ms.common.Result;
import com.zhangz.ms.domain.MiaoShaUser;
import com.zhangz.ms.redis.RedisService;
import com.zhangz.ms.service.MiaoShaUserService;
import com.zhangz.ms.util.MD5Util;
import com.zhangz.ms.vo.LoginVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/11
 * @time: 22:59
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private MiaoShaUserService miaoShaUserService;

    private static Logger logger =  LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     *  验证登录
     * @param  loginVO
     * @Param bindingResult 存放validation的校验结果
     * @return
     */
    @RequestMapping("/loginin")
    public Result loginin(@Valid LoginVO loginVO ){
        logger.info(loginVO.toString());
        // 参数校验
//        if(StringUtils.isBlank(loginVO.getNickname()))return Result.error(CodeMsg.NICKNAME_NOT_NULL);
//        if (ObjectUtils.isEmpty(loginVO.getPassword())) return Result.error(CodeMsg.PASSWORD_NOT_NULL);
        // 登录验证
        boolean isPass = miaoShaUserService.login(loginVO);

        return isPass  ? Result.success("登录成功") : Result.error(CodeMsg.SERVER_ERROR);
    }

}
