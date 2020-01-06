package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 22:06
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public enum SignUpInfoEnum {

    WAIT_ADMISSION(1,"待录用"),
    HAD_ADMISSION(2,"已录用"),
    HAD_SETTLEMENT(3,"已结算"),
    WAIT_EVALUATE(4,"待评价"),
    CANCEL(5,"已取消")

    ;

    //根据code 找到desc 描述
    private static final Map<Integer,SignUpInfoEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (SignUpInfoEnum type: EnumSet.allOf(SignUpInfoEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static SignUpInfoEnum fromValue(Integer code) {
        SignUpInfoEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    SignUpInfoEnum(Integer code, String msg) {
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
