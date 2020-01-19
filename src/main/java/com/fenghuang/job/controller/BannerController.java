package com.fenghuang.job.controller;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.ReqBanner;
import com.fenghuang.job.request.ReqBannerStatus;
import com.fenghuang.job.service.BannerService;
import com.fenghuang.job.utils.QiniuCloudUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/23 17:48
 * @Email: 15290810931@163.com
 */
@Api(value = "轮播图信息表相关接口",description = "轮播图信息表相关接口")
@Slf4j
@RestController
public class BannerController {

    @Autowired
    BannerService bannerService;

    @ApiOperation(value = "管理员后台添加轮播图banner")
    @PostMapping("/insertBanner")
    @ResponseBody
    public Result insertBanner(@RequestBody ReqBanner reqBanner){
        Result result = bannerService.insertBanner(reqBanner);
        return result;
    }

    @ApiOperation(value = "根据条件查找banner")
    @PostMapping("/findBanner")
    @ResponseBody
    public Result findBanner(@RequestBody ReqBanner reqBanner){
        return Result.success(bannerService.findBanner(reqBanner));
    }
    @ApiOperation(value = "根据ID更新轮播图状态")
    @PostMapping("/modifyBannerStatus")
    public Result modifyBannerStatus(ReqBannerStatus reqBannerStatus){
        return Result.success(bannerService.modifyBannerStatus(reqBannerStatus));
    }

    @ApiOperation(value = "根据id 查询banner 详情")
    @GetMapping("/findBannerById")
    public Result findBannerById(@RequestParam("id") Integer id){
        return Result.success(bannerService.findBannerById(id));
    }

    @ResponseBody
    @RequestMapping(value="/uploadImg", method=RequestMethod.POST)
    public Result uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) {
        Result result = new Result();
        if (image.isEmpty()) {
            result.setCode(400);
            result.setMessage("文件为空，请重新上传");
            return result;
        }
        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                //使用base64方式上传到七牛云
                String url = QiniuCloudUtil.put64image(bytes, imageName);
                result.setCode(200);
                result.setMessage("文件上传成功");
                result.setData(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            log.info("文件上传发生异常:{}",e.getMessage());
        } finally {
            return Result.success(result);
        }
    }

    @PostMapping("/deleteTest")
    public Result deleteTest(@RequestParam("userName") String userName){
       return Result.success(bannerService.deleteTest(userName));
    }


}
