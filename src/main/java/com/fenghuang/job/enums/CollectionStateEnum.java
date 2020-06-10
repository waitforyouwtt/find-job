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
public enum CollectionStateEnum {

    YES(1,"收藏"),
    NO(2,"未收藏")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,CollectionStateEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (CollectionStateEnum type: EnumSet.allOf(CollectionStateEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static CollectionStateEnum fromValue(Integer code) {
        CollectionStateEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    CollectionStateEnum(Integer code, String msg) {
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
