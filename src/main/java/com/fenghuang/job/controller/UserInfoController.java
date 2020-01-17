package com.fenghuang.job.controller;

import com.fenghuang.job.config.CheckToken;
import com.fenghuang.job.config.LoginToken;
import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.*;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.BusinessUtils;
import com.fenghuang.job.request.ReqRegisterCode;
import com.fenghuang.job.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/17 11:20
 * @Email: 15290810931@163.com
 */
@Api(value = "用户信息表相关接口",description = "用户信息表相关接口")
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "常规方式注册新用户")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestBody ReqUserInfo reqUserInfo){
        return userInfoService.insertUser(reqUserInfo);
    }

    @ApiOperation(value = "更新用户状态信息")
    @PostMapping("/modifyUserStatus")
    public Result modifyUserStatus(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate){
        return userInfoService.modifyUserInfo(reqUserInfoUpdate);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/modifyUserInfo")
    public Result modifyUserInfo(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate){
        return userInfoService.modifyUserInfo(reqUserInfoUpdate);
    }

    @ApiOperation(value = "根据用户名获取用户信息记录[可能有重名的人]")
    @GetMapping("/findUserInfoByUserName")
    public Result findUserInfoByUserName(@RequestParam("userName") String userName){
      return Result.success(userInfoService.findUserInfoByUserName(userName)) ;
    }

    @ApiOperation(value = "根据用户id|用户昵称|用户手机号|身份证 获取唯一一条用户信息记录")
    @PostMapping("/findUserInfo")
    public Result findUserInfo(@RequestBody ReqUserInfoQuery reqUserInfoQuery){
      return Result.success(userInfoService.findUserInfo(reqUserInfoQuery));
    }

    @PostMapping("/findUserInfoPage")
    @ApiOperation(value = "根据条件查询用户信息并进行分页")
    public Result findUserInfoPage(@RequestBody ReqUserInfoQuery reqUserInfoQuery){
       return Result.success(userInfoService.findUserInfoPage(reqUserInfoQuery));
    }

    @PostMapping("/changePassword")
    @ApiOperation(value = "用户进行修改密码")
    public Result changePassword(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate){
        return userInfoService.changePassword(reqUserInfoUpdate);
    }

    @PostMapping("/messageRegister")
    @ApiOperation(value = "用户短信注册，发送验证码")
    public Result messageRegister(@RequestParam("messageId")String messageId,@RequestParam("signId")String signId,
                                  @RequestParam("mobile")String mobile,HttpServletRequest request){
        String ip = BusinessUtils.getIpAddress(request);
        return userInfoService.messageRegister(messageId,signId,mobile,ip);
    }

    @PostMapping("/checkRegisterCode")
    @ApiOperation(value = "用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败")
    public Result checkRegisterCode(@RequestBody ReqRegisterCode registerCode) {
        return userInfoService.checkRegisterCode(registerCode);
    }

    @PostMapping("/login")
    @ApiOperation(value = "前台：根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录;" +
            "type分别为: 1，2,3,4,5")
    public Result login(@RequestBody ReqLoginUserInfo reqLoginUserInfo,HttpServletRequest request){
        String ip = BusinessUtils.getIpAddress(request);
        reqLoginUserInfo.setLoginIp(ip);
        return userInfoService.login(reqLoginUserInfo);
    }

    @PostMapping("/loginByMessage")
    @ApiOperation(value = "使用短信进行登录，发送验证码")
    @LoginToken
    public Result loginByMessage(@RequestBody HttpServletRequest request,@RequestParam("messageId")String messageId,
                                 @RequestParam("signId")String signId,@RequestParam("mobile")String mobile){
        String ip = BusinessUtils.getIpAddress(request);
        return userInfoService.loginByMessage(messageId,signId,mobile,ip);
    }

    @PostMapping("/checkLoginCode")
    @ApiOperation(value = "用户短信登录，输入验证码，验证通过则登录成功，验证失败则登录失败")
    @LoginToken
    public Result checkLoginCode(@RequestBody ReqLoginUserInfo reqLoginUserInfo) {
        return userInfoService.checkLoginCode(reqLoginUserInfo);
    }

    @ApiOperation(value = "根据Id 获取用户记录详情")
    @GetMapping("/findUserById")
    public Result findUserById(@RequestParam("id") Integer id){
        return userInfoService.findUserById(id);
    }

    @ApiOperation(value = "生成验证码，返回给前端")
    @RequestMapping(value="/getImage",method= RequestMethod.GET)
    public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 存入会话session
        HttpSession session = request.getSession(true);
        // 删除以前的
        session.removeAttribute("verCode");
        session.removeAttribute("codeTime");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        session.setAttribute("codeTime", LocalDateTime.now());
        // 生成图片
        int w = 100, h = 30;
        OutputStream out = response.getOutputStream();
        VerifyCodeUtils.outputImage(w, h, out, verifyCode);
    }

    @ApiOperation(value = "用户登陆，校验用户名，密码，验证码等信息。")
    @RequestMapping(value="valid-login",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,String> validImage(HttpServletRequest request, HttpSession session, ReqLoginUserInfo userInfo){
        String code = request.getParameter("code");
        Object verCode = session.getAttribute("verCode");
        Map<String,String> result = new HashMap<>(16);
        if (null == verCode) {
            request.setAttribute("errmsg", "验证码已失效，请重新输入");
            result.put("rCode","1000");
            result.put("message","验证码已失效，请重新输入");
            return result;
        }
        String verCodeStr = verCode.toString();
        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Result login = userInfoService.login(userInfo);

        if(verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)){
            request.setAttribute("errmsg", "验证码错误");
            result.put("rCode","1001");
            result.put("message","验证码错误");
            return result;
        } else if((now-past)/1000/60 >5){
            request.setAttribute("errmsg", "验证码已过期，重新获取");
            result.put("rCode","1002");
            result.put("message","验证码已过期，重新获取");
            return result;
        } else if(login == null){
            request.setAttribute("errmsg", "用户名或密码错误");
            result.put("rCode","1003");
            result.put("message","用户名或密码错误");
            return result;
        }else  {
            //saveLoginLog(nickName,request);
            //验证成功，删除存储的验证码
            session.removeAttribute("verCode");

            request.getSession();
            result.put("rCode","200");
            result.put("message","登陆成功");
            return result;
        }
    }

    //😂
    @CheckToken
    @ApiOperation(value = "根据登录token获取登录用户的钱包余额，收藏数，浏览数")
    @PostMapping("/findWalletAndCollectionAndBrowse")
    public Result findWalletAndCollectionAndBrowse(@RequestParam("token") String token){
      return Result.success(userInfoService.findWalletAndCollectionAndBrowse(token));
    }


}
