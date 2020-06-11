package com.fenghuang.job.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/8 18:00
 * @Email: 15290810931@163.com
 */
public enum SalaryUnitEnum {

    DAY(1,"天"),
    HOUR(2,"小时"),
    MONTH(3,"月"),
    //发传单就需要按次
    CI(4,"次"),
    //比如销售就需要按单
    DAN (5,"单")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,SalaryUnitEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (SalaryUnitEnum type: EnumSet.allOf(SalaryUnitEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static SalaryUnitEnum fromValue(Integer code) {
        SalaryUnitEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> typeEnumList() {
        //javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (SalaryUnitEnum enumClass : SalaryUnitEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put( "code", enumClass.getCode() );
            map.put( "message", enumClass.getMsg() );
            list.add( map );
        }
        return list;
    }

    SalaryUnitEnum(Integer code, String msg) {
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
