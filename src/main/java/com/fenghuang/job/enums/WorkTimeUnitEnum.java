package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/8 18:09
 * @Email: 15290810931@163.com
 * 需要工作周期
 */
public enum  WorkTimeUnitEnum {

    HOUR(1, "小时"),
    DAY(2, "天"),
    MONTH(3, "月"),
    YEAR(4, "年");

    //根据code 找到desc 描述
    private static final Map<Integer,WorkTimeUnitEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (WorkTimeUnitEnum type: EnumSet.allOf(WorkTimeUnitEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static WorkTimeUnitEnum fromValue(Integer code) {
        WorkTimeUnitEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    WorkTimeUnitEnum(Integer code, String msg) {
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
