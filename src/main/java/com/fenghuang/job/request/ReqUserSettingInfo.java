package com.fenghuang.job.request;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/13 8:53
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ReqUserSettingInfo {

    private Integer id;

    private String token;

    private Integer userId;

    private Integer employmentIntention;

    private String personalSignature;

    private Integer sendLikeJob;

    private Integer sendEmail;

    private Integer sendMessage;

    private Integer sendWechat;

    private Integer sendPublicAccount;

    private String shieldCompanys;

    private Integer isPersonalInformationPublic;

    private Integer settingState;

}
