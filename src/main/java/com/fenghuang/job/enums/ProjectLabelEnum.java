package com.fenghuang.job.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
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

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> typeEnumList() {
        //javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (ProjectLabelEnum enumClass : ProjectLabelEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put( "code", enumClass.getCode() );
            map.put( "message", enumClass.getMsg() );
            list.add( map );
        }
        return list;
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
