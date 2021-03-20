package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.dto.Status;
import com.fanlu.staffmanage.entity.Advice;
import com.fanlu.staffmanage.entity.Feedback;
import com.fanlu.staffmanage.entity.StaffInfo;
import com.fanlu.staffmanage.entity.UserCoop;
import com.fanlu.staffmanage.service.SuperService;
import com.fanlu.staffmanage.utils.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YGwhere on 2021/2/20 19:08
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
@RequestMapping("/super")
public class SuperController {

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
        if (staffInfoPageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", staffInfoPageInfo.getTotal())
                    .add("pages", staffInfoPageInfo.getPages()).add("result", staffInfoPageInfo.getList()).toJsonObject();
        }
    }

    @GetMapping("/incs")
    public JSONObject getIncInfos(Integer page, Integer pagesize) {
        PageInfo<UserCoop> userCoopPageInfo = superService.selectUserCoopInfoByPage(page, pagesize);
        if (userCoopPageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", userCoopPageInfo.getTotal())
                    .add("pages", userCoopPageInfo.getPages()).add("incs", userCoopPageInfo.getList()).toJsonObject();
        }
    }

    @GetMapping("/status")
    public JSONObject getStatus() {
        int users = Status.getUsers();
        if (users == -1) {
            users = superService.selectUserCount();
            Status.setUsers(users);
        }
        return Message.success().add("register_inc", Status.getRegisterInc())
                .add("users", users).add("look", Status.getLook()).toJsonObject();
    }

    @PutMapping("/feedback")
    public JSONObject readStatus(Integer feedId) {
        if (superService.updateFeedbackStatus(feedId)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

    @GetMapping("/feedback")
    public JSONObject getFeedbacks(Integer userId, Integer page, Integer pagesize) {
        PageInfo<Feedback> pageInfo = superService.selectFeedbacksByUser(userId, page, pagesize);
        if (pageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", pageInfo.getTotal()).add("pages", pageInfo.getPages())
                    .add("feedbacks", pageInfo.getList()).toJsonObject();
        }
    }

    @DeleteMapping("/feedback")
    public JSONObject deleteFeedback(Integer feedId) {
        if(superService.deleteFeedback(feedId)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

    @GetMapping("/advice")
    public JSONObject selectAllAdvices(Integer page, Integer pagesize) {
        PageInfo<Advice> pageInfo = superService.selectAllAdvice(page, pagesize);
        if (pageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", pageInfo.getTotal()).add("pages", pageInfo.getPages())
                    .add("advices", pageInfo.getList()).toJsonObject();
        }
    }

    @PostMapping("/advice")
    public JSONObject addAdvice(String groups, Integer userId, String message) {
        Integer[] groupId = JSONObject.parseObject(groups, Integer[].class);
        if(groupId.length == 0) {
            return Message.fail().toJsonObject();
        }
        boolean sal = true;
        for(Integer group : groupId) {
            sal = sal && superService.addAdvice(group, userId, message);
        }
        if(sal) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

    @DeleteMapping("/advice")
    public JSONObject deleteAdvice(Integer id) {
        if (superService.deleteAdvice(id)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

}
