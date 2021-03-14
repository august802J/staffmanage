package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.service.AdminService;
import com.fanlu.staffmanage.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YGwhere on 2021/2/21 22:20
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

//    /**
//     * 测试接口，发布将删除
//     * @return
//     */
//    @GetMapping("/test")
//    public String Test() {
//        return "test success";
//    }

    @PostMapping("/user")
    public JSONObject addAdmin(String account,String password) {
        if(adminService.addAdmin(account,password)){
            return Message.success().toJsonObject();
        }else{
            return Message.fail().toJsonObject();
        }
    }

    @DeleteMapping("/user")
    public JSONObject deleteAdmin(int id) {
        if(adminService.deleteAdmin(id)){
            return Message.success().toJsonObject();
        }else{
            return Message.fail().toJsonObject();
        }
    }
}
