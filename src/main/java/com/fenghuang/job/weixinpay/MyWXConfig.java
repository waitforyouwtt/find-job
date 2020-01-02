package com.fenghuang.job.weixinpay;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/2 11:12
 * @Email: 15290810931@163.com
 */
public class MyWXConfig implements WXPayConfig {

    private byte[] certData;

    public MyWXConfig() throws Exception {
	       /* String certPath = "";
	        File file = new File(certPath);
	        InputStream certStream = new FileInputStream(file);
	        this.certData = new byte[(int) file.length()];
	        certStream.read(this.certData);
	        certStream.close();*/
    }

    public String getAppID() {
        return "xxx";
    }

    public String getMchID() {
        return "xxx";
    }


    public String getKey() {
        return "xxx";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

}
