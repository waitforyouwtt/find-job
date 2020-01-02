package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 15:42
 * @Email: 15290810931@163.com
 */
public enum ProjectStatusEnum {

    INIT(1,"初始化"),
    CONDUCTING(2,"进行中"),
    END(3,"已结束");

    //根据code 找到desc 描述
    private static final Map<Integer,ProjectStatusEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (ProjectStatusEnum type: EnumSet.allOf(ProjectStatusEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static ProjectStatusEnum fromValue(Integer code) {
        ProjectStatusEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    ProjectStatusEnum(Integer code, String msg) {
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
