package com.fenghuang.job.utils;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/2 11:17
 * @Email: 15290810931@163.com
 */
public class UUID {

    private static Date date = new Date();
    private static StringBuilder buf = new StringBuilder();
    private static int seq = 0;
    private static final int ROTATION = 99999;

    public static synchronized long next() {
        if (seq > ROTATION)
            seq = 0;
        buf.delete(0, buf.length());
        date.setTime(System.currentTimeMillis());
        String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
        return Long.parseLong(str);
    }

    private UUID(){

    }
}
