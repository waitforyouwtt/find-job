package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.constant.Constants;
import com.fenghuang.job.dao.master.MessageRecordMapper;
import com.fenghuang.job.entity.MessageRecord;
import com.fenghuang.job.enums.DeleteEnum;
import com.fenghuang.job.enums.MessageTypeEnum;
import com.fenghuang.job.request.ReqMessageRecord;
import com.fenghuang.job.request.ReqMessageRecordQuery;
import com.fenghuang.job.request.ReqMessageRecordQuery2;
import com.fenghuang.job.service.MessageRecordService;
import com.fenghuang.job.utils.DateUtil;
import com.fenghuang.job.view.MessageRecordView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.text.ParseException;
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
    MessageRecordMapper messageCountMapper;

    /**
     * 插入短信统计表
     * @param ip
     * @param mobile
     * @param messageType
     */
    @Override
    @Async
    public void insertMessageCountRecordByType(String ip, String mobile, Integer messageType) {

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
        }
        messageCountMapper.insertSelective(messageRecord);
    }
    /**
     * 插入短信统计表
     *
     * @param reqMessageCount
     * @return
     */
    @Override
    public int insertMessageCount(ReqMessageRecord reqMessageCount) {
        log.info("插入短信统计表 请求参数：{}", JSON.toJSONString(reqMessageCount));
        MessageRecord messageCount = new MessageRecord();
        BeanCopier beanCopier = BeanCopier.create(ReqMessageRecord.class,MessageRecord.class,false);
        beanCopier.copy(reqMessageCount,messageCount,null);
        messageCount.setCreateDate(new Date());
        messageCount.setUpdateDate(new Date());
        messageCount.setSendDate(new Date());
        messageCount.setFounder(reqMessageCount.getFounder());
        messageCount.setModifier(reqMessageCount.getFounder());
        return messageCountMapper.insertSelective(messageCount);
    }

    /**
     * 根据条件进行查询短信统计且分页
     *
     * @param messageCountQuery
     * @return
     */
    @Override
    public PageInfo<MessageRecordView> findMessageCountPage(ReqMessageRecordQuery messageCountQuery) {
        log.info("根据条件进行查询短信统计且分页 请求参数：{}",JSON.toJSONString(messageCountQuery));
        PageInfo<MessageRecordView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(messageCountQuery.getPageNum(),messageCountQuery.getPageSize());
            List<MessageRecord> queryMessageCount = messageCountMapper.findMessageCountPage(messageCountQuery);
            if (CollectionUtils.isEmpty( queryMessageCount )){
                pageInfo = new PageInfo<>( new ArrayList<>(  ) );
            }else{
                List<MessageRecordView> views = new ArrayList<>();
                convertView(queryMessageCount, views);
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
     * @param reqMessageCountQuery2
     */
    @Override
    public List<MessageRecordView> findMessageCount(ReqMessageRecordQuery2 reqMessageCountQuery2){
        log.info(" 根据条件统计一个人30分钟之内发送短信的条数 请求参数：{}",JSON.toJSONString(reqMessageCountQuery2));
        try {
            reqMessageCountQuery2.setOneHourAgoDate(DateUtil.subMinute(DateUtils.parseDate(reqMessageCountQuery2.getCurrentSendDate(),"yyyy-MM-dd hh:mm:ss"), Constants.MESSAGE_MINUTE));
        } catch (ParseException e) {
            log.info("根据条件统计一个人30分钟之内发送短信的条数 时间转换异常：{}",e.getMessage());
        }
        List<MessageRecord> queryMessageCount = messageCountMapper.findMessageCount(reqMessageCountQuery2);
        log.info("根据条件统计一个人30分钟之内发送短信的条数 返回记录：{}",JSON.toJSONString(queryMessageCount));
        List<MessageRecordView> views = new ArrayList<>();
        convertView(queryMessageCount, views);
        return views;
    }

    private void convertView(List<MessageRecord> queryMessageCount, List<MessageRecordView> views) {
        queryMessageCount.stream().forEach(messageCount -> {
            MessageRecordView view = new MessageRecordView();
            BeanCopier beanCopier = BeanCopier.create(MessageRecord.class, MessageRecordView.class, false);
            beanCopier.copy(messageCount,view,null);
            view.setMessageTypeDesc(MessageTypeEnum.fromValue(messageCount.getMessageType()).getMsg());
            views.add(view);
        });
    }
}
