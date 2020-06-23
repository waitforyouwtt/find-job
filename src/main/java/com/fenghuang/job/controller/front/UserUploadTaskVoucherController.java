package com.fenghuang.job.controller.front;

import com.fenghuang.job.service.UserUploadTaskVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luoxian
 * @Date: 2020/6/23 18:30
 * @Email: 15290810931@163.com
 */
@RestController
public class UserUploadTaskVoucherController {

    @Autowired
    UserUploadTaskVoucherService voucherService;
}
