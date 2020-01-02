package com.fenghuang.job.utils;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.constant.Constants;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/2 14:07
 * @Email: 15290810931@163.com
 */
@Slf4j
public class CreateBucket {

    /**
     *
     * @param accessKey 七牛云个人中心的key
     * @param secretKey  个人中心密码
     * @param bucketName  空间名称
     * @param storageArea 存储区域
     */
    public void createBucket(String accessKey,String secretKey,String bucketName,String storageArea) {
        Auth auth = Auth.create(accessKey,secretKey);
        String path = "/mkbucketv2/" + encode(bucketName.getBytes()) + "/region/"+ storageArea +"\n";
        String access_token = auth.sign(path);
        log.info("获取的access_token是：{}",access_token);
        String url = Constants.QINIUURL + encode(bucketName.getBytes()) + "/region/" + storageArea;
        log.info("创建bucketName的Url是：{}",url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "QBox " + access_token).build();
        Response re = null;
        try {
            re = client.newCall(request).execute();
            if (re.isSuccessful() == true) {
               log.info("创建bucketName返回true结果是：{}", JSON.toJSONString(re));
            } else {
                log.info("创建bucketName返回false结果是：{}", JSON.toJSONString(re));
            }
        } catch (IOException e) {
            log.info("创建bucketName异常信息是：{}", e.getMessage());
        }
    }

    /**
     * 编码
     *
     * @param bstr
     * @return String
     */
    public static String encode(byte[] bstr) {
        return new sun.misc.BASE64Encoder().encode(bstr);
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {

        new CreateBucket().createBucket("BlqVwU2wwmukHVpL3uG4ppwq6xuO5DykebFuvj2A", "rlbTR0M_G55oVLz7EjQjZjPILranJsoMndkbWO_J","banner_bucket","z1");
    }
}
