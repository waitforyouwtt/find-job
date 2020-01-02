package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/26 16:32
 * @Email: 15290810931@163.com
 */
public enum MessageTypeEnum {

    REGISTER(1,"注册"),
    FIND_BANK_PASSWORD(2,"找回密码"),
    LOGIN(3,"登录");

    //根据code 找到desc 描述
    private static final Map<Integer,MessageTypeEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (MessageTypeEnum type: EnumSet.allOf(MessageTypeEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static MessageTypeEnum fromValue(Integer code) {
        MessageTypeEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    MessageTypeEnum(Integer code, String msg) {
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
