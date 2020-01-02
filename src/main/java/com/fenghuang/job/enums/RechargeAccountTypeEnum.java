package com.fenghuang.job.enums;

import io.swagger.annotations.ApiModel;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 14:30
 * @Email: 15290810931@163.com
 */
@ApiModel(value = "充值账号类型")
public enum RechargeAccountTypeEnum {

    ALIPAY(1,"支付宝"),
    WECHAT(2,"微信"),
    QQ(3,"QQ"),
    BANK(4,"银行转账"),
    RED_ENVELOPES(5,"红包"),
    WECHAT_TRANSFER_ACCOUNTS(6,"微信转账");

    //根据code 找到desc 描述
    private static final Map<Integer,RechargeAccountTypeEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (RechargeAccountTypeEnum type: EnumSet.allOf(RechargeAccountTypeEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static RechargeAccountTypeEnum fromValue(Integer code) {
        RechargeAccountTypeEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    RechargeAccountTypeEnum(Integer code, String msg) {
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
