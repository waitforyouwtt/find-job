package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.master.MessageRecordMapper;
import com.fenghuang.job.entity.MessageRecord;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.MessageTypeEnum;
import com.fenghuang.job.request.ReqMessageRecordQuery;
import com.fenghuang.job.request.ReqMessageRecordQuery2;
import com.fenghuang.job.service.MessageRecordService;
import com.fenghuang.job.utils.DateUtil;
import com.fenghuang.job.view.MessageRecordView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/25 18:08
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class MessageRecordServiceImpl implements MessageRecordService {

    @Resource
    MessageRecordMapper messageRecordMapper;

    /**
     * 插入短信统计表
     * @param ip
     * @param mobile
     * @param messageType
     */
    @Override
    @Async
    public void insertMessageRecordByType(String ip, String mobile, Integer messageType) {
        //发送短信成功，则往短信统计记录表中插入相关数据
        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setSendIp(ip);
        messageRecord.setCreateDate(new Date());
        messageRecord.setUpdateDate(new Date());
        messageRecord.setFounder(mobile);
        messageRecord.setModifier(mobile);
        messageRecord.setMobile(mobile);
        messageRecord.setSendDate(new Date());
        messageRecord.setIsDelete(DeleteEnum.NO.getCode());
        if (messageType.equals(MessageTypeEnum.REGISTER.getCode())) {
            messageRecord.setMessageType(MessageTypeEnum.REGISTER.getCode());
            messageRecord.setSendContent("您正在进行使用短信注册新账号");
        } else if (messageType.equals(MessageTypeEnum.LOGIN.getCode())) {
            messageRecord.setMessageType(MessageTypeEnum.LOGIN.getCode());
            messageRecord.setSendContent("您正在进行使用短信登录账号");
        } else if(messageType.equals(MessageTypeEnum.FIND_BANK_PASSWORD.getCode())){
            messageRecord.setMessageType(MessageTypeEnum.FIND_BANK_PASSWORD.getCode());
            messageRecord.setSendContent("您正在进行使用短信找回密码");
        } else if(messageType.equals(MessageTypeEnum.MODIFY_MOBILE.getCode())){
            messageRecord.setMessageType(MessageTypeEnum.MODIFY_MOBILE.getCode());
            messageRecord.setSendContent("您正在进行使用短信修改绑定手机号");
        } else if(messageType.equals(MessageTypeEnum.MERCHANT_REGISTER.getCode())){
            messageRecord.setMessageType(MessageTypeEnum.MERCHANT_REGISTER.getCode());
            messageRecord.setSendContent("商家正在进行使用短信注册账号");
        }
        messageRecordMapper.insertSelective(messageRecord);
    }


    /**
     * 根据条件进行查询短信统计且分页
     *
     * @param messageRecordQuery
     * @return
     */
    @Override
    public PageInfo<MessageRecordView> findMessageRecordPage(ReqMessageRecordQuery messageRecordQuery) {
        log.info("根据条件进行查询短信统计且分页 请求参数：{}",JSON.toJSONString(messageRecordQuery));
        PageInfo<MessageRecordView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(messageRecordQuery.getPageNum(),messageRecordQuery.getPageSize());
            List<MessageRecord> queryMessageRecord = messageRecordMapper.findMessageRecordPage(messageRecordQuery);
            if (CollectionUtils.isEmpty( queryMessageRecord )){
                pageInfo = new PageInfo<>( new ArrayList<>(  ) );
            }else{
                List<MessageRecordView> views = new ArrayList<>();
                convertView(queryMessageRecord, views);
                pageInfo = new PageInfo<>( views );
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info( "根据条件进行查询短信统计且分页 查询异常:{}",e.getMessage() );
        }
        return pageInfo;
    }

    /**
     * 根据条件统计一个人一小时发送短信的条数
     *
     * @param reqMessageRecordQuery2
     */
    @Override
    public List<MessageRecordView> countMessageRecordSize(ReqMessageRecordQuery2 reqMessageRecordQuery2) {
        log.info(" 根据条件统计一个人30分钟之内发送短信的条数 请求参数：{}", JSON.toJSONString(reqMessageRecordQuery2));
        reqMessageRecordQuery2.setOneHourAgoDate(DateUtil.subMinute(reqMessageRecordQuery2.getCurrentSendDate(), Constants.MESSAGE_MINUTE));
        List<MessageRecord> queryMessageRecord = messageRecordMapper.findMessageRecordSize(reqMessageRecordQuery2);
        List<MessageRecordView> views = new ArrayList<>();
        convertView(queryMessageRecord, views);
        return views;
    }

    private void convertView(List<MessageRecord> queryMessageRecord, List<MessageRecordView> views) {
        queryMessageRecord.stream().forEach(messageRecord -> {
            MessageRecordView view = new MessageRecordView();
            BeanCopier beanCopier = BeanCopier.create(MessageRecord.class, MessageRecordView.class, false);
            beanCopier.copy(messageRecord,view,null);
            view.setMessageTypeDesc(MessageTypeEnum.fromValue(messageRecord.getMessageType()).getMsg());
            views.add(view);
        });
    }
}
