package com.fanlu.staffmanage.controller.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YGwhere on 2021/2/6 22:53
 * Description: 配置好相关文件将删除该类
 *
 * @Author 15011_
 */
@RestController
public class IndexController {

    @Autowired
    private StringEncryptor encryptor;


    // 需要加密的明文
    private String password = "";

    /**
     * 测试jasypt加密解密
     */
    @GetMapping("/jasypt")
    public void testJasypt() {

        String encryptPwd = encryptor.encrypt(password);
        System.out.println(password + " 加密为:" + encryptPwd);

    }
}

