package com.fenghuang.job.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luoxian
 * @Date: 2020/6/9 14:17
 * @Email: 15290810931@163.com
 */
public class IdCardUtil {

    /**
     * 根据身份证的号码算出当前身份证持有者的性别和年龄 18位身份证
     *
     * @return
     * @throws Exception
     */
    public static Map<String, String> getCarInfo(String CardCode) {
        Map<String, String> map = new HashMap<String, String>();

        String year = CardCode.substring(6).substring(0, 4);// 得到年份
        String yue = CardCode.substring(10).substring(0, 2);// 得到月份
        String day=CardCode.substring(12).substring(0,2);//得到日

        String birthday = year.concat( "-" ).concat( yue ).concat( "-" ).concat( day);
        String sex;
        // 判断性别
        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {
            //女
            sex = "2";
        } else {
            //男
            sex = "1";
        }
        Date date = new Date();// 得到当前的系统时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 当前年份
        String fyear = format.format(date).substring(0, 4);
        // 月份
        String fyue = format.format(date).substring(5, 7);
        String fday=format.format(date).substring(8,10);
        int age = 0;
        // 当前月份大于用户出身的月份表示已过生
        if (Integer.parseInt(yue) <= Integer.parseInt(fyue)) {
            age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;
        } else {
            // 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year);
        }
        map.put( "birthday", birthday);
        map.put("gender", sex);
        map.put("age", String.valueOf( age ));
        return map;
    }
}
