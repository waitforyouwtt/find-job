package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/8 18:00
 * @Email: 15290810931@163.com
 */
public enum SettlementCycleEnum {
    END_WORK(1,"完工结"),
    DAY(2,"日结"),
    HOUR(3,"周结"),
    MONTH(4,"月结")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,SettlementCycleEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (SettlementCycleEnum type: EnumSet.allOf(SettlementCycleEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static SettlementCycleEnum fromValue(Integer code) {
        SettlementCycleEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    SettlementCycleEnum(Integer code, String msg) {
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
