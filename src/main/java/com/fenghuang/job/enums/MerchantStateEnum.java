package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/6 22:03
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public enum MerchantStateEnum {

    APPLY(0,"申请中"),
    NORMAL(1,"通过/正常"),
    NOT_VALIDATE(2,"驳回"),
    INVALID(3,"失效")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer, MerchantStateEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (MerchantStateEnum type: EnumSet.allOf( MerchantStateEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static MerchantStateEnum fromValue(Integer code) {
        MerchantStateEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    MerchantStateEnum(Integer code, String msg) {
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
