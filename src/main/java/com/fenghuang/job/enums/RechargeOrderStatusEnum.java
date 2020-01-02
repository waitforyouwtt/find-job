package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 15:39
 * @Email: 15290810931@163.com
 */
public enum RechargeOrderStatusEnum {

    SUCCESS(1,"成功"),
    FAIL(2,"失败"),
    PROCESSING(3,"处理中");

    //根据code 找到desc 描述
    private static final Map<Integer,RechargeOrderStatusEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (RechargeOrderStatusEnum type: EnumSet.allOf(RechargeOrderStatusEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static RechargeOrderStatusEnum fromValue(Integer code) {
        RechargeOrderStatusEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    RechargeOrderStatusEnum(Integer code, String msg) {
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
