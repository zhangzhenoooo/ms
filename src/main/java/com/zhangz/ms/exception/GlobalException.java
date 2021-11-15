package com.zhangz.ms.exception;

import com.zhangz.ms.common.CodeMsg;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/14
 * @time: 23:11
 */
public class GlobalException extends RuntimeException {

    private CodeMsg codeMsg;
    public GlobalException(CodeMsg codeMsg){
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
