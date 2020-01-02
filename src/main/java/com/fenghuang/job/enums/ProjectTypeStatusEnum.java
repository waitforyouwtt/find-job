package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/22 11:45
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public enum  ProjectTypeStatusEnum {

    NORMAL(1,"正常"),
    PROHIBIT(2,"禁用");

    //根据code 找到desc 描述
    private static final Map<Integer,ProjectTypeStatusEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (ProjectTypeStatusEnum type: EnumSet.allOf(ProjectTypeStatusEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static ProjectTypeStatusEnum fromValue(Integer code) {
        ProjectTypeStatusEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    ProjectTypeStatusEnum(Integer code, String msg) {
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
