package com.fenghuang.job.exception;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/3 13:49
 * @Email: 15290810931@163.com
 */
public enum CommonEnum implements BaseErrorInfoInterface {

    SUCCESS(200, "成功!"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    /** 错误码 */
    private Integer code;

    /** 错误描述 */
    private String msg;

    CommonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
