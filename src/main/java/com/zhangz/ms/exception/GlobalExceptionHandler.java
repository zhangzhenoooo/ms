package com.zhangz.ms.exception;

import com.zhangz.ms.common.CodeMsg;
import com.zhangz.ms.common.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/14
 * @time: 22:53
 * 全局异常类
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     *  异常拦截，统一处理
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request,
                                   HttpServletResponse response,
                                   Exception e){
        if (e instanceof  GlobalException ){
            GlobalException globalException = (GlobalException) e;
            return Result.error(globalException.getCodeMsg());
        }else if (e instanceof BindException){
            BindException bindException  = (BindException) e;
            List<ObjectError> allErrors = bindException.getAllErrors();
            ObjectError error = allErrors.get(0);
            String defaultMessage = error.getDefaultMessage();
            return Result.error(CodeMsg.BING_ERROR.fillArgs(defaultMessage));
        }else {
           return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}
