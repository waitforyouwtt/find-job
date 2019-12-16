package com.fenghuang.job.dao.cluster;

import com.fenghuang.job.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/16 16:27
 * @Email: 15290810931@163.com
 */
@Mapper
public interface UserInfoClusterDao {

    UserInfo findUser(@Param("userName") String userName);
}
