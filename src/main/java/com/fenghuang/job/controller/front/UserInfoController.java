package com.fenghuang.job.controller.front;

import com.fenghuang.job.entity.Result;
import com.fenghuang.job.request.*;
import com.fenghuang.job.service.UserInfoService;
import com.fenghuang.job.utils.BusinessUtils;
import com.fenghuang.job.request.ReqRegisterCode;
import com.fenghuang.job.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value( "${message.messageId}" )
    private String messageId;

    @Value( "${message.signId}" )
    private String signId;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/login")
    @ApiOperation(value = "前台：根据[用户名&密码]|[用户昵称&密码]|[手机号&密码]|[身份证号&密码]进行登录")
    public Result login(@RequestBody ReqLoginUserInfo reqLoginUserInfo,HttpServletRequest request){
        reqLoginUserInfo.setLoginIp(BusinessUtils.getIp(request));

        Result result = userInfoService.ordinaryLogin(reqLoginUserInfo);
        if (result.getCode() == 200){
            request.getSession().setAttribute("userSession", result.getData());
        }
        return result;
    }

    @PostMapping("/loginByMessage")
    @ApiOperation(value = "使用短信进行登录，发送验证码")

    public Result loginByMessage(@RequestBody HttpServletRequest request,@RequestParam("mobile")String mobile){
        return userInfoService.loginByMessage(messageId,signId,mobile,BusinessUtils.getIp(request));
    }

    @PostMapping("/checkLoginCode")
    @ApiOperation(value = "用户短信登录，输入验证码，验证通过则登录成功，验证失败则登录失败")

    public Result checkLoginCode(@RequestBody ReqLoginUserInfo reqLoginUserInfo) {
        return userInfoService.checkLoginCode(reqLoginUserInfo);
    }

    @ApiOperation(value = "常规方式注册新用户且不允许昵称重复")
    @PostMapping("/userRegister")
    public Result userRegister(@RequestBody ReqUserInfo reqUserInfo){
        return userInfoService.insertUser(reqUserInfo);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/modifyUserInfo")
    public Result modifyUserInfo(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate,@RequestHeader("token") String token){
        reqUserInfoUpdate.setToken(token);
        return userInfoService.modifyUserInfo(reqUserInfoUpdate);
    }

    @PostMapping("/changePassword")
    @ApiOperation(value = "用户进行修改密码")
    public Result changePassword(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate,@RequestHeader("token") String token){
        reqUserInfoUpdate.setToken(token);
        return userInfoService.changePassword(reqUserInfoUpdate);
    }

    @PostMapping("/messageRegister")
    @ApiOperation(value = "用户短信注册，发送验证码")
    public Result messageRegister(@RequestBody ReqRegisterCode reqRegisterCode ,HttpServletRequest request){
        return userInfoService.messageRegister(messageId,signId,reqRegisterCode.getMobile(),BusinessUtils.getIp(request));
    }

    @PostMapping("/checkRegisterCode")
    @ApiOperation(value = "用户短信注册，输入密码并校验验证码，验证通过则注册成功，验证失败则注册失败")
    public Result checkRegisterCode(@RequestBody ReqRegisterCode registerCode) {
        return userInfoService.checkRegisterCode(registerCode);
    }

    @ApiOperation(value = "通过短信找回密码-发送短信")
    @PostMapping("/messageFindPwd")
    public Result messageFindPwd(HttpServletRequest request,@RequestParam("mobile")String mobile){
        return userInfoService.messageFindPwd(messageId,signId,mobile,BusinessUtils.getIp(request));
    }

    @ApiOperation(value = "通过短信找回密码-输入验证码，验证通过则修改密码成功，验证失败则修改密码失败")
    @PostMapping("/retrievePassword")
    public Result  retrievePassword(@RequestBody ReqLoginUserInfo userInfo ,HttpServletRequest request){
        return userInfoService.retrievePassword(userInfo);
    }

    @ApiOperation(value = "用户修改手机号-发送验证码")
    @PostMapping("/modifyMobileMessage")
    public Result  modifyMobileMessage(@RequestBody HttpServletRequest request,@RequestParam("mobile")String mobile){
        return userInfoService.modifyMobileMessage(messageId,signId,mobile,BusinessUtils.getIp(request));
    }

    @PostMapping("/modifyMobile")
    @ApiOperation(value = "用户修改手机号-发送验证码，验证通过则登录成功，验证失败则登录失败")
    public Result modifyMobile(@RequestBody ReqLoginUserInfo reqLoginUserInfo,@RequestHeader("token") String token) {
        reqLoginUserInfo.setToken(token);
        return userInfoService.modifyMobile(reqLoginUserInfo);
    }

    //😂
    @ApiOperation(value = "根据登录token获取登录用户的昵称，头像，钱包余额，收藏数，浏览数，我的兼职等信息")
    @PostMapping("/findMoWaByToken")
    public Result findMoWaByToken(@RequestHeader("token") String token){
        return userInfoService.findMoWaByToken(token);
    }

    @ApiOperation(value = "根据登录token获取个人信息")
    @PostMapping("/findPersonalInformationByToken")
    public Result findPersonalInformationByToken(@RequestHeader("token") String token){
        return userInfoService.findPersonalInformationByToken(token);
    }

    @ApiOperation(value = "通过token查询个人信息&个人配置的最后更新时间")
    @PostMapping("/findLocalMessageByToken")
    public Result  findLocalMessageByToken(@RequestHeader("token") String token){
        return userInfoService.findLocalMessageByToken(token);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/loginOut")
    public Result loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return Result.success();
    }


    @ApiOperation(value = "更新用户状态信息")
    @PostMapping("/modifyUserStatus")
    public Result modifyUserStatus(@RequestBody ReqUserInfoUpdate reqUserInfoUpdate,@RequestHeader("token") String token){
        reqUserInfoUpdate.setToken(token);
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
        Result login = userInfoService.ordinaryLogin(userInfo);

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

}
