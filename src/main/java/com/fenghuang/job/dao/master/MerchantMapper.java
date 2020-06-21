package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.Merchant;
import com.fenghuang.job.request.ReqMerchantLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    //根据手机号查询商家
    Merchant queryMerchantByMobile(@Param( "mobile" ) String mobile);

    //商家登录：账号 或 手机号
    Merchant findMerchantByLogin(@Param( "loginUser" ) String loginUser);
}