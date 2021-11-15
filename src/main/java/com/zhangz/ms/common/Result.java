package com.zhangz.ms.common;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/9
 * @time: 21:39
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /**
     *  成功
     * @param data
     * @return
     */
    public  static <T> Result <T> success(T data){
        return new Result<>(data);
    }

    /**
     *  失败
     * @param codeMsg
\     * @param <T>
     * @return
     */
    public  static <T> Result <T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }


    private Result(T data){
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
     }

    public Result(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    public int getCode() {
        return code;
    }



    public String getMsg() {
        return msg;
    }


    public T getData() {
        return data;
    }

}
