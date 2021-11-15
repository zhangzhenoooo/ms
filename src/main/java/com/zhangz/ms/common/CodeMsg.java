package com.zhangz.ms.common;

/**
 * @email 1804919062@qq.com
 * @author:zhangz
 * @date: 2021/11/9
 * @time: 21:59
 */
public class CodeMsg {
    public static final CodeMsg BING_ERROR = new CodeMsg(50000, "%S");
    public static final CodeMsg ERROR = new CodeMsg(500,"服务器异常");
    private int code;
    private String msg;


    /**
     *     通用异常
     */
    public  static CodeMsg SUCCESS = new CodeMsg(200,"success");
    public  static CodeMsg  SERVER_ERROR = new CodeMsg(500,"服务器异常");

    /**
     * 登录异常 5002XX
     * @param code
     * @param msg
     */
    public  static CodeMsg  USER_LOGIN_PASS = new CodeMsg(200,"登录验证成功！");
    public  static CodeMsg  USER_NOT_FOUND = new CodeMsg(500201,"用户不存在！请检查登录信息！");
    public  static CodeMsg   USER_NICKNAME_OR_PASS_ERROR = new CodeMsg(500202,"用户名或密码错误！");
    public static CodeMsg NICKNAME_NOT_NULL  = new CodeMsg(500203,"昵称不能为空！");
    public static final CodeMsg PASSWORD_NOT_NULL = new CodeMsg(500204,"密码不能为空！");



    /**
     * 商品异常
     * @param code
     * @param msg
     */

    /**
     * 订单异常
     * @param code
     * @param msg
     */



    private CodeMsg(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    /**
     *  带参数
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object args){
        int code = this.code;
        String message = String.format(this.msg,args);
        return new CodeMsg(code,message);
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
