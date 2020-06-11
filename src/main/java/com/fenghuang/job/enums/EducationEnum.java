package com.fenghuang.job.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: luoxian
 * @Date: 2020/6/9 14:52
 * @Email: 15290810931@163.com
 */
public enum EducationEnum {

    PRIMARY_SCHOOL(1,"小学"),
    MIDDLE_SCHOOL(2,"初中"),
    HIGH_SCHOOL(3,"高中"),
    UNIVERSITY(4,"大学");

    //根据code 找到desc 描述
    private static final Map<Integer,EducationEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (EducationEnum type: EnumSet.allOf(EducationEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static EducationEnum fromValue(Integer code) {
        EducationEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> typeEnumList() {
        //javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (EducationEnum enumClass : EducationEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put( "code", enumClass.getCode() );
            map.put( "message", enumClass.getMsg() );
            list.add( map );
        }
        return list;
    }

    EducationEnum(Integer code, String msg) {
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
