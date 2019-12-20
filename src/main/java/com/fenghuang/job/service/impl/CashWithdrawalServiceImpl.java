package com.fenghuang.job.service.impl;

import com.alibaba.fastjson.JSON;
import com.fenghuang.job.dao.master.CashWithdrawalMapper;
import com.fenghuang.job.entity.CashWithdrawal;
import com.fenghuang.job.request.ReqCashWithdrawal;
import com.fenghuang.job.service.CashWithdrawalService;
import com.fenghuang.job.view.CashWithdrawalView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/20 10:59
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class CashWithdrawalServiceImpl implements CashWithdrawalService {

    @Autowired
    CashWithdrawalMapper cashWithdrawalMapper;
    /**
     * 提现申请
     *
     * @param reqCashWithdrawal
     * @return
     */
    @Override
    public int insertCashWithdrawal(ReqCashWithdrawal reqCashWithdrawal) {
        log.info("提现申请请求参数：{}", JSON.toJSONString(reqCashWithdrawal));
        CashWithdrawal cashWithdrawal = new CashWithdrawal();
        BeanCopier beanCopier = BeanCopier.create(ReqCashWithdrawal.class, CashWithdrawal.class, false);
        beanCopier.copy(reqCashWithdrawal,cashWithdrawal,null);
        return cashWithdrawalMapper.insertSelective(cashWithdrawal);
    }

    /**
     * 根据条件查询且分页提现订单申请信息表
     *
     * @param reqCashWithdrawal
     * @return
     */
    @Override
    public PageInfo<CashWithdrawalView> findCashWithdrawalPage(ReqCashWithdrawal reqCashWithdrawal) {
        log.info("根据条件查询且分页提现订单申请信息表 请求参数：{}",JSON.toJSONString(reqCashWithdrawal));
        PageInfo<CashWithdrawalView> pageInfo = null;
        try{
            Page<?> page = PageHelper.startPage(reqCashWithdrawal.getPageNum(),reqCashWithdrawal.getPageSize());
            List<CashWithdrawal> cashWithdrawalViewList = cashWithdrawalMapper.findCashWithdrawal(reqCashWithdrawal);
            if (CollectionUtils.isEmpty(cashWithdrawalViewList)){
                pageInfo = new PageInfo<>(new ArrayList<>());
            }else{
                List<CashWithdrawalView> views = new ArrayList<>();
                cashWithdrawalViewList.stream().forEach(cashWithdrawal -> {
                    CashWithdrawalView view = new CashWithdrawalView();
                    BeanCopier beanCopier = BeanCopier.create(CashWithdrawal.class, CashWithdrawalView.class, false);
                    beanCopier.copy(cashWithdrawal,view,null);
                    views.add(view);
                });
                pageInfo = new PageInfo<>(views);
            }
            log.info("总共有:{}",page.getTotal()+"条数据,实际返回{}:",page.size()+"两条数据!");
        }catch (Exception e){
            log.info("根据条件查询且分页提现订单申请信息表 查询异常：{}",e.getMessage());
        }
        return pageInfo;
    }

    /**
     * 根据订单id更新提现订单信息表状态
     *
     * @param reqCashWithdrawal
     * @return
     */
    @Override
    public int modifyCashWithdrawalStatus(ReqCashWithdrawal reqCashWithdrawal) {
        log.info("根据订单id更新提现订单信息表状态 请求参数：{}",JSON.toJSONString(reqCashWithdrawal));
        CashWithdrawal cashWithdrawal = new CashWithdrawal();
        BeanCopier beanCopier = BeanCopier.create(ReqCashWithdrawal.class, CashWithdrawal.class, false);
        beanCopier.copy(reqCashWithdrawal,cashWithdrawal,null);
        return cashWithdrawalMapper.updateByPrimaryKeySelective(cashWithdrawal);
    }
}
