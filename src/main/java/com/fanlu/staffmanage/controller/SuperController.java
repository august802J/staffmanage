package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.StaffInfo;
import com.fanlu.staffmanage.entity.UserCoop;
import com.fanlu.staffmanage.service.SuperService;
import com.fanlu.staffmanage.utils.Message;
import com.github.pagehelper.PageInfo;
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

//    /**
//     * 测试接口，发布将删除
//     *
//     * @return
//     */
//    @GetMapping("/test")
//    public String Test() {
//        return "test success";
//    }

    @Autowired
    SuperService superService;

    @PostMapping("/user")
    public JSONObject addSuper(String account, String password) {
        if (null == account || "".equals(account) || null == password || "".equals(password)) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        if (superService.addManager(account, password)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

    @GetMapping("/inc")
    public JSONObject getIncDetails(Integer groupId) {
        if (groupId == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        Inc inc = superService.getIncDetail(groupId);
        String incJson = JSON.toJSONString(inc);
        if ("".equals(incJson)) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("inc", incJson).toJsonObject();
        }
    }

    @GetMapping("/staves")
    public JSONObject getStaves(Integer group_id, Integer page, Integer pagesize) {
        if (group_id == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        PageInfo<StaffInfo> staffInfoPageInfo = superService.selectStaffInfoByPage(group_id, page, pagesize);
        if(staffInfoPageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", staffInfoPageInfo.getTotal())
                    .add("pages", staffInfoPageInfo.getPages()).add("result", staffInfoPageInfo.getList()).toJsonObject();
        }
    }

    @GetMapping("/incs")
    public JSONObject getIncInfos(Integer page, Integer pagesize) {
        PageInfo<UserCoop> userCoopPageInfo = superService.selectUserCoopInfoByPage(page, pagesize);
        if(userCoopPageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", userCoopPageInfo.getTotal())
                    .add("pages", userCoopPageInfo.getPages()).add("incs", userCoopPageInfo.getList()).toJsonObject();
        }

    }
}
