package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/26 18:07
 * @Email: 15290810931@163.com
 */
public enum CashWithdrawalStatusEnum {

    PROCESSING(1,"处理中"),
    SUCCESS(2,"成功"),
    FAIL(3,"失败");


    //根据code 找到desc 描述
    private static final Map<Integer,CashWithdrawalStatusEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (CashWithdrawalStatusEnum type: EnumSet.allOf(CashWithdrawalStatusEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static CashWithdrawalStatusEnum fromValue(Integer code) {
        CashWithdrawalStatusEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    CashWithdrawalStatusEnum(Integer code, String msg) {
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
