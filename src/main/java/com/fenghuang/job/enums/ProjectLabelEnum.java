package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/8 17:42
 * @Email: 15290810931@163.com
 */
public enum ProjectLabelEnum {

    LONG_WORKER(1,"长期工"),
    SHORT_WORKER(2,"短期工"),
    WINTER_WORKER(3,"寒假工"),
    SUMMER_WORKER(4,"暑假工"),
    HOURLY_WORKER (5,"钟点工")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,ProjectLabelEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (ProjectLabelEnum type: EnumSet.allOf(ProjectLabelEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static ProjectLabelEnum fromValue(Integer code) {
        ProjectLabelEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    ProjectLabelEnum(Integer code, String msg) {
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
