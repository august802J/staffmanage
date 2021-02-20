package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.service.impl.UserServiceImpl;
import com.fanlu.staffmanage.utils.Constant;
import com.fanlu.staffmanage.utils.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserServiceImpl userService;

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

        User user = new User(account, password);
        int id = userService.addUser(user, incObject);
        return Message.success();
    }

    @PostMapping("/findpassword")
    public Message checkAccount(String account) {
        if(null == account || account.length() != Constant.ACCOUNT_LENGTH) {
            return Message.fail(628, "请求格式错误");
        }
        if (userService.checkIsAccount(account)) {
            return Message.fail(626, "账号不存在");
        } else {
            return Message.success();
        }
    }

    @PutMapping("/findpassword")
    public Message changePassword(String account, String pwd) {
        if (null == account || account.length() != Constant.ACCOUNT_LENGTH || null == pwd
                || pwd.length() < Constant.PASSWORD_MIN_LENGTH
                || pwd.length() > Constant.PASSWORD_MAX_LENGTH) {
            return Message.fail(628, "请求格式错误");
        }
        if (userService.updatePassword(account, pwd)) {
            return Message.success();
        } else {
            return Message.fail();
        }
    }
}
