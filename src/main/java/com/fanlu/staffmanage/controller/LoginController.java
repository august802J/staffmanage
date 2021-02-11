package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
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
    public void register(String account, String password, @RequestBody JSONObject inc) {

    }

    @PostMapping("/findpassword")
    public void checkAccount(String account) {

    }

    @PutMapping("/findpassword")
    public void changePassword(String account, String pwd) {

    }
}
