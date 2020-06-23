package com.fenghuang.job.dao.master;

import com.fenghuang.job.entity.UserUploadTaskVoucher;

public interface UserUploadTaskVoucherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserUploadTaskVoucher record);

    int insertSelective(UserUploadTaskVoucher record);

    UserUploadTaskVoucher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserUploadTaskVoucher record);

    int updateByPrimaryKey(UserUploadTaskVoucher record);
}