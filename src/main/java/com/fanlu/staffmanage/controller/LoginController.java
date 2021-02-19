package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.utils.Constant;
import com.fanlu.staffmanage.utils.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YGwhere on 2021/2/8 21:20
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
public class LoginController {
    @PostMapping("/login")
    public void login(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(account, password));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/register")
    public Message register(String account, String password, @RequestBody JSONObject inc) {
        if (null == account || account.length() != Constant.ACCOUNT_LENGTH || null == password
                || password.length() < Constant.PASSWORD_MIN_LENGTH
                || password.length() > Constant.PASSWORD_MAX_LENGTH || null == inc) {
            return Message.fail(628, "请求格式错误");
        }
        String incStr = inc.toJSONString();
        Inc incObject = JSONObject.parseObject(incStr, Inc.class);
        if (incObject.check()) {
            return Message.fail(628, "请求格式错误");
        }

        return Message.success();
    }

    @PostMapping("/findpassword")
    public void checkAccount(String account) {

    }

    @PutMapping("/findpassword")
    public void changePassword(String account, String pwd) {

    }
}
