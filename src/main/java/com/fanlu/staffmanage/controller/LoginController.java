package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.dto.RegisterMessage;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.service.LoginService;
import com.fanlu.staffmanage.utils.Constant;
import com.fanlu.staffmanage.utils.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YGwhere on 2021/2/8 21:20
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 默认转向登录页面
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "redirect: /login";
    }

    /**
     * 转向登录成功页面
     * @return
     */
    @GetMapping("/success")
    public String loginSuccess() {
        return "success";
    }

    /**
     * 转向登录失败页面
     * @return
     */
    @GetMapping("/noPermission")
    public String loginError() {
        return "noPermission";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录接口
     * @param account
     * @param password
     */
    @PostMapping("/login")
    public JSONObject login(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(account, password));
        } catch (AuthenticationException e) {
            return Message.fail(627, "密码错误").toJsonObject();
        }
        return Message.success().toJsonObject();
    }

    @PostMapping("/logout")
    public JSONObject logout() {
        return Message.success().toJsonObject();
    }

    @PostMapping("/register")
    public JSONObject register(@RequestBody JSONObject registerMessageJson) {
        RegisterMessage registerMessage = JSONObject.parseObject(registerMessageJson.toJSONString(), RegisterMessage.class);
        if (registerMessage.check()) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        Inc inc =  registerMessage.getInc();
        User user = new User(registerMessage.getAccount(), registerMessage.getPassword());
        int id = loginService.addUser(user, inc);
        return Message.success().toJsonObject();
    }

    @PostMapping("/findpassword")
    public JSONObject checkAccount(String account) {
        if(null == account || account.length() != Constant.ACCOUNT_LENGTH) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        if (!loginService.checkIsAccount(account)) {
            return Message.fail(626, "账号不存在").toJsonObject();
        } else {
            return Message.success().toJsonObject();
        }
    }

    @PutMapping("/findpassword")
    public JSONObject changePassword(String account, String pwd) {
        if (null == account || account.length() != Constant.ACCOUNT_LENGTH || null == pwd
                || pwd.length() < Constant.PASSWORD_MIN_LENGTH
                || pwd.length() > Constant.PASSWORD_MAX_LENGTH) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        if (loginService.updatePassword(account, pwd)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }
}
