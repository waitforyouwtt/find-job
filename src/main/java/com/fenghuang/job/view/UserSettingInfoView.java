package com.fenghuang.job.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/13 9:48
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class UserSettingInfoView implements Serializable {

    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("求职意向：1.离职-随时到岗，2.在职-随时到岗 3.在职-月内到岗 4.在职-考虑机会 5.在职-暂不考虑")
    private Integer employmentIntention;
    private String employmentIntentionDesc;

    @ApiModelProperty("个性签名")
    private String personalSignature;

    @ApiModelProperty("是否允许为你动态推送推荐可能喜欢的职位：1允许 2不允许")
    private Integer sendLikeJob;
    private String sendLikeJobDesc;

    @ApiModelProperty("是否允许邮箱推送：1允许 2 不允许")
    private Integer sendEmail;
    private String  sendEmailDesc;

    @ApiModelProperty("是否允许短信推送：1允许 2 不允许")
    private Integer sendMessage;
    private String  sendMessageDesc;

    @ApiModelProperty("是否允许微信推送：1允许 2 不允许")
    private Integer sendWechant;
    private String  sendWechantDesc;

    @ApiModelProperty("是否允许公众号推送：1允许 2 不允许")
    private Integer sendPublicAccount;
    private String  sendPublicAccountDesc;

    @ApiModelProperty("屏蔽的公司集合")
    private String shieldCompanys;

    @ApiModelProperty("个人信息是否公开：1.公开 2.对外部隐藏 3.全部隐藏")
    private Integer isPersonalInformationPublic;
    private String  isPersonalInformationPublicDesc;

    @ApiModelProperty("设置的状态：1.正常 2.失效")
    private Integer settingState;

    @ApiModelProperty("系统版本号")
    private String version;
}
