package com.fanlu.staffmanage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YGwhere on 2021/2/21 22:20
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 测试接口，发布将删除
     * @return
     */
    @GetMapping("/test")
    public String Test() {
        return "test success";
    }
}
