package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 14:39
 * @Email: 15290810931@163.com
 */
public enum LoginStatusEnum {

    SUCCESS(1,"成功"),
    FAIL(2,"失败"),
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,LoginStatusEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (LoginStatusEnum type: EnumSet.allOf(LoginStatusEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static LoginStatusEnum fromValue(Integer code) {
        LoginStatusEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    LoginStatusEnum(Integer code, String msg) {
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
