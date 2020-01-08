package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/8 17:57
 * @Email: 15290810931@163.com
 */
public enum GenderRequirementEnum {

    MAN(1,"男"),
    WOMAN(2,"女"),
    NO_RESTRICTION(3,"不限制")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,GenderRequirementEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (GenderRequirementEnum type: EnumSet.allOf(GenderRequirementEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static GenderRequirementEnum fromValue(Integer code) {
        GenderRequirementEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    GenderRequirementEnum(Integer code, String msg) {
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
