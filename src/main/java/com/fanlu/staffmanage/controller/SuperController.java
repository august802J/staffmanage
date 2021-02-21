package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.service.impl.SuperServiceImpl;
import com.fanlu.staffmanage.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YGwhere on 2021/2/20 19:08
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
@RequestMapping("/super")
public class SuperController {

    /**
     * 测试接口，发布将删除
     * @return
     */
    @GetMapping("/test")
    public String Test() {
        return "test success";
    }

    @Autowired
    SuperServiceImpl superService;

    @PostMapping("/user")
    public JSONObject addSuper(String account, String password) {
        if (superService.addManager(account, password)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

    @GetMapping("/inc")
    public JSONObject getIncDetails(int groupId) {
        Inc inc = superService.getIncDetail(groupId);
        String incJson = JSON.toJSONString(inc);
        if("".equals(incJson)) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("inc", incJson).toJsonObject();
        }
    }

    @GetMapping("/staves")
    public JSONObject getStaves(int page, int pagesize) {
        return null;
    }

    @GetMapping("/incs")
    public JSONObject getIncInfo(int page, int pagesize) {
        return null;
    }
}
