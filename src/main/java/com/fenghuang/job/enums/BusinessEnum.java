package com.fenghuang.job.enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 14:30
 * @Email: 15290810931@163.com
 */
public enum BusinessEnum {

    RECORD_REPETITION(1001,"记录重复"),
    MISSING_PARAMETERS(1002,"参数缺失"),
    RECORD_ALREADY_EXISTS(1003,"记录已存在"),
    RECORD_NOT_EXIST(1004,"记录不存在"),

    ;

    BusinessEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String  msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
