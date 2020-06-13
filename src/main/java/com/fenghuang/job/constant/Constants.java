package com.fenghuang.job.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 14:59
 * @Email: 15290810931@163.com
 */
public class Constants {

    //秘钥串
    public static final String  SECRET_KEY = "1A2B3C4D5E6F7G8H9I0J0K9L8M7N6O1P2Q3R4S1TUVWXYZ";
    //发送短信时,如果当前手机号| ip 30分钟内频繁的发送短信超过MESSAGE_COUNT条，则视为用户进行恶意攻击
    public static final Integer MESSAGE_MINUTE = -30;
    //发送短信时,如果当前手机号| ip 30分钟内频繁的发送短信超过5条，则视为用户进行恶意攻击
    public static final Integer MESSAGE_COUNT  = 2;
    //魔蛙默认用户
    public static final String MOWA = "mowa_";


    //七牛云地址
    public static final String QINIUURL = "http://rs.qiniu.com/mkbucketv2/";
    //秘钥
    public static final String MOWA_MIYAO = "shanghaizhaohaoxinxikejiyouxiangongsi";

    public static List<Integer> sortList(){
        List<Integer> sortList = new ArrayList<>();
        //直辖市
        sortList.add(110100);
        sortList.add(310100);
        sortList.add(120100);
        sortList.add(500100);
        //省份
        sortList.add( 130000 ); //河北
        sortList.add( 140000 ); //山西
        sortList.add( 330000 ); //浙江
        sortList.add( 320000 ); //江苏
        sortList.add( 370000 ); //山东
        sortList.add( 410000 ); //河南
        sortList.add( 340000 ); //安徽
        sortList.add( 610000 ); //陕西
        sortList.add( 430000 ); //湖南
        sortList.add( 420000 ); //湖北
        sortList.add( 520000 ); //贵州
        sortList.add( 360000 ); //江西
        sortList.add( 510000 ); //四川
        sortList.add( 350000 ); //福建
        sortList.add( 440000 ); //广东
        sortList.add( 460000 ); //海南
        sortList.add( 630000 ); //青海
        sortList.add( 620000 ); //甘肃
        sortList.add( 530000 ); //云南
        sortList.add( 220000 ); //吉林
        sortList.add( 210000 ); //辽宁
        sortList.add( 230000 ); //黑龙江
        sortList.add( 450000 ); //广西壮族自治区
        sortList.add( 640000 ); //宁夏回族自治区
        sortList.add( 540000 ); //西藏自治区
        sortList.add( 150000 ); //内蒙古自治区
        sortList.add( 650000 ); //新疆维吾尔自治区
        sortList.add( 810000 ); //香港特别行政区
        sortList.add( 820000 ); //澳门特别行政区
        sortList.add(  710000); //台湾
        return sortList;
    }
}
