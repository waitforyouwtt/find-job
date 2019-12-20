package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.CashWithdrawal;

public interface CashWithdrawalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CashWithdrawal record);

    int insertSelective(CashWithdrawal record);

    CashWithdrawal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CashWithdrawal record);

    int updateByPrimaryKey(CashWithdrawal record);
}