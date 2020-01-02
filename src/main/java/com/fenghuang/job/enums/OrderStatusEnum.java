package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 22:04
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public enum OrderStatusEnum {
    WAIT_BEGIN( 1, "待开始" ),
    PROCESSING( 2, "进行中" ),
    DEAL_SUCCESS( 3, "交易成功" ),
    DEAL_CANCEL( 4, "交易取消[用户]" ),
    DEAL_CLOSE( 5, "交易关闭[商家]" );

    //根据code 找到desc 描述
    private static final Map<Integer,OrderStatusEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (OrderStatusEnum type: EnumSet.allOf(OrderStatusEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static OrderStatusEnum fromValue(Integer code) {
        OrderStatusEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

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
