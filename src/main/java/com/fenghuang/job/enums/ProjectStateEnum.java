package com.fenghuang.job.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 15:42
 * @Email: 15290810931@163.com
 */
public enum ProjectStateEnum {

    PUBLISH(1,"项目发布"),
    APPLY(2,"用户报名"),
    WORK(3,"开始工作"),
    FINISHED(4,"交易完成")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer,ProjectStateEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (ProjectStateEnum type: EnumSet.allOf(ProjectStateEnum.class)){
            valueLookup.put(type.code, type);
        }
    }
    public static ProjectStateEnum fromValue(Integer code) {
        ProjectStateEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }

    ProjectStateEnum(Integer code, String msg) {
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
