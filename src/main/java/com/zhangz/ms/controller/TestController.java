package com.zhangz.ms.controller;

import com.zhangz.ms.common.CodeMsg;
import com.zhangz.ms.common.Result;
import com.zhangz.ms.domain.MiaoShaUser;
import com.zhangz.ms.redis.RedisService;
import com.zhangz.ms.redis.UserKey;
import com.zhangz.ms.service.MiaoShaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/9
 * @time: 21:34
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    private MiaoShaUserService miaoShaUserService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/hello")
    public Result hello(){
        return Result.success(null);
    }

    @RequestMapping("/error")
    public Result error(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    /**
     *  页面模板
     * @return
     */
    @RequestMapping("/thylmeleaf")
    public ModelAndView thylmeleaf(ModelAndView modelAndView){
        modelAndView.setViewName("hello");
        modelAndView.addObject("name","thymeleaf");
        return modelAndView;
    }

    @RequestMapping("/thylmeleaf2")
    public String thylmeleaf2(ModelAndView modelAndView){


        return "hello";
    }

    /**
     *  操作数据库
     * @return
     */
    @RequestMapping("/getData")
    public Result getData(){
        MiaoShaUser miaoShaUser = miaoShaUserService.getUserById(1);
        return Result.success(miaoShaUser);
    }

    /**
     *  测试事物
     */
    @RequestMapping("/testSw")
    public Result testSw(){
        boolean result =   miaoShaUserService.testSw();
        return Result.success(result);
    }

    @RequestMapping("/redisGet")
    public Result testRedis(){
        Long t = redisService.get(UserKey.getById,"key1",Long.class);
        return Result.success(t);
    }
    @RequestMapping("/redisSet")
    public Result redisSet(){
        boolean t = redisService.set(UserKey.getById,"key1",12L);
        return Result.success(t);
    }

    @RequestMapping("/redisGetUser")
    public Result redisGetUser(){
        MiaoShaUser miaoShaUser = redisService.get(UserKey.getById,1+"", MiaoShaUser.class);
        return Result.success(miaoShaUser);
    }
    @RequestMapping("/redisSetUser")
    public Result redisSetUser(){
        MiaoShaUser miaoShaUser = new MiaoShaUser();
        miaoShaUser.setNickname("tests");
        miaoShaUser.setId("10");
        boolean t = (boolean) redisService.set(UserKey.getById, miaoShaUser.getId()+"", miaoShaUser);
        return Result.success(t);
    }


}
