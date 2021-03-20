package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.SuperService;
import com.fanlu.staffmanage.service.UserService;
import com.fanlu.staffmanage.utils.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YGwhere on 2021/2/21 22:20
 * Description: staffmanage
 *
 * @Author 15011_
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SuperService superService;

    /**
     * 修改指定者评价(已测)
     * @param evaluationMessageJson
     * @return
     */
    @PutMapping("/evaluation")
    public JSONObject updateStaff_evaluation(@RequestBody JSONObject evaluationMessageJson,Integer id) {
        StaffEvaluation staffEvaluation = JSONObject.parseObject(evaluationMessageJson.toJSONString(), StaffEvaluation.class);
        if (id==null||"".equals(JSONObject.toJSONString(staffEvaluation)) || staffEvaluation.getId() == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        if(userService.isTrue(staffEvaluation.getStaffId(),id)){
            StaffEvaluation staffEvaluation1 = userService.updateStaff_evaluation(staffEvaluation);
            String staff_eva = JSONObject.toJSONString(staffEvaluation1);
            if (staff_eva.equals("")) {
                return Message.fail().toJsonObject();
            } else {
                return Message.success().add("staffEvaluation", staff_eva).toJsonObject();
            }
        }else{
            return Message.fail(628,"没有权限").toJsonObject();
        }

    }

    /**
     * 查询多个评价
     * @param id
     * @param page
     * @param pagesize
     * @return
     */
    @GetMapping("/evaluations")
    public JSONObject checkStaffs_evaluation(Integer id, Integer page, Integer pagesize) {
        if (id == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        PageInfo<StaffEvaluation> staffEvaluationpageInfo = userService.selectStaff_evaByPage(id, page, pagesize);
        if (staffEvaluationpageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            System.out.println(staffEvaluationpageInfo.getList());
            return Message.success().add("num", staffEvaluationpageInfo.getTotal())
                    .add("pages", staffEvaluationpageInfo.getPages()).add("result", staffEvaluationpageInfo.getList()).toJsonObject();
        }
    }

    /**
     * 添加评论（已测）
     * @param evaluationMessageJson
     * @return
     */
    @PostMapping("/evaluation")
    public JSONObject addStaff_evaluation(@RequestBody JSONObject evaluationMessageJson) {
        StaffEvaluation staffEvaluation = JSONObject.parseObject(evaluationMessageJson.toJSONString(), StaffEvaluation.class);
        if ("".equals(JSONObject.toJSONString(staffEvaluation)) || staffEvaluation.getStaffId() == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        StaffEvaluation staffEvaluation1 = userService.addStaff_evaluation(staffEvaluation);
        String staff_eva = JSONObject.toJSONString(staffEvaluation1);
        if ("".equals(staff_eva)) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("staffEvaluation", staff_eva).toJsonObject();
        }
    }

    /**
     * 得到员工详情页面（已测）
     * @param id
     * @return
     */
    @GetMapping("/staff")
    public JSONObject checkStaff(Integer id) {
        if (id == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        StaffInfo staffInfo = userService.checkStaff_info(id);
        StaffEvaluation staffEvaluation = userService.checkStaff_evaluation(id);
        StaffJob staffJob = userService.checkStaff_job(id);
        StaffAbility staffAbility = userService.checkStaff_ability(id);
        StaffEdu staffEdu = userService.checkStaff_edu(id);
        String staff_info = JSONObject.toJSONString(staffInfo);
        String staff_eva = JSONObject.toJSONString(staffEvaluation);
        String staff_abi = JSONObject.toJSONString(staffAbility);
        String staff_job = JSONObject.toJSONString(staffJob);
        String staff_edu = JSONObject.toJSONString(staffEdu);
        if (staff_info.equals("")) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("staffInfo", staff_info).add("staffEvaluation", staff_eva)
                    .add("staffJob", staff_job).add("staffAbility", staff_abi).add("staffEdu", staff_edu)
                    .toJsonObject();
        }
    }

    /**
     * 删除本公司指定员工（已测）
     * @param id
     * @return
     */
    @DeleteMapping("/staves")
    public JSONObject deleteStaff(Integer id) {
        if (id == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        StaffInfo staffInfo = userService.checkStaff_info(id);
        String staff_info = JSONObject.toJSONString(staffInfo);
        if (staff_info.equals("")) {
            return Message.fail().toJsonObject();
        } else {
            userService.deleteStaff_job(id);
            userService.deleteStaff_edu(id);
            userService.deleteStaff_ability(id);
            userService.deleteStaff_eva(id);
            if (userService.deleteStaff(id)) {
                return Message.success().toJsonObject();
            } else {
                return Message.fail().toJsonObject();
            }
        }
    }

    /*
     * 对方法的描述
     *
     根据名字模糊查询员工
     * @return
     * @throws
     */
    @GetMapping("/stavesbyname")
    public JSONObject getStavesbyName(String name, Integer page, Integer pagesize) {
        if (name == null) {
            return getAllStaves(page,pagesize);
        }
        PageInfo<StaffInfo> staffsInfo = userService.selectStaffInfoByName(name, page, pagesize);
        if (staffsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            List<Inc> staffsInc = new ArrayList<>();
            for(StaffInfo staff:staffsInfo.getList()){
                staffsInc.add(superService.getIncDetail(staff.getStaffInfoGroupid()));
            }
            return Message.success().add("num", staffsInfo.getTotal())
                    .add("pages", staffsInfo.getPages()).add("staffsInfo", staffsInfo.getList()).add("staffsInc",staffsInc).toJsonObject();
        }
    }

    @GetMapping("/stavesbyinc")
    public JSONObject getStavesbyInc(String name, Integer page, Integer pagesize) {
        if (name == null) {
            return getAllStaves(page,pagesize);
        }
        PageInfo<StaffInfo> staffsInfo = userService.selectStaffInfoByinc(name, page, pagesize);
        if (staffsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            List<Inc> staffsInc = new ArrayList<>();
            for(StaffInfo staff:staffsInfo.getList()){
                staffsInc.add(superService.getIncDetail(staff.getStaffInfoGroupid()));
            }
            return Message.success().add("num", staffsInfo.getTotal())
                    .add("pages", staffsInfo.getPages()).add("staffsInfo", staffsInfo.getList()).add("staffsInc",staffsInc).toJsonObject();
        }
    }



    /*
     * 对方法的描述
     * 
     查询所有员工列表
     * @return 
     * @throws 
     */
    @GetMapping("/allstaves")
    public JSONObject getAllStaves(Integer page, Integer pagesize) {
        PageInfo<StaffInfo> staffsInfo = userService.selectAllStaffInfoByPage(page, pagesize);
        if (staffsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            List<Inc> staffsInc = new ArrayList<>();
            for(StaffInfo staff:staffsInfo.getList()){
                staffsInc.add(superService.getIncDetail(staff.getStaffInfoGroupid()));
            }
            return Message.success().add("num", staffsInfo.getTotal())
                    .add("pages", staffsInfo.getPages()).add("staffsInfo", staffsInfo.getList()).add("staffsInc",staffsInc).toJsonObject();
        }
    }
    /**
     * 查询多个本公司人员
     * @param id
     * @param page
     * @param pagesize
     * @return
     */
    @GetMapping("/staves")
    public JSONObject getStaves(Integer id, Integer page, Integer pagesize) {
        if (id == null) {
            return Message.fail(628, "请求格式错误").toJsonObject();
        }
        PageInfo<StaffInfo> staffsInfo = userService.selectStaffInfoByPage(id, page, pagesize);
        if (staffsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            List<Inc> staffsInc = new ArrayList<>();
            for(StaffInfo staff:staffsInfo.getList()){
                staffsInc.add(superService.getIncDetail(staff.getStaffInfoGroupid()));
            }
            return Message.success().add("num", staffsInfo.getTotal())
                    .add("pages", staffsInfo.getPages()).add("staffsInfo", staffsInfo.getList()).add("inc",staffsInc).toJsonObject();
        }
    }

    /**
     * 查看本公司多个离职员工（已测）
     * @param page
     * @param pagesize
     * @return
     */
    @GetMapping("/resigns")
    public JSONObject getResigns(Integer page, Integer pagesize) {
        PageInfo<StaffInfo> staff_ResignsInfo = userService.selectResignsByPage(page, pagesize);
        if (staff_ResignsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", staff_ResignsInfo.getTotal())
                    .add("pages", staff_ResignsInfo.getPages()).add("result", staff_ResignsInfo.getList()).toJsonObject();
        }
    }

    /**
     * 添加一条反馈
     * @param message
     * @param userId
     * @return
     */
    @PostMapping("/feedback")
    public JSONObject addFeedback(String message, Integer userId) {
        if(userService.insertFeedback(message, userId)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

    @GetMapping("/advice")
    public JSONObject selectAdvices(Integer userId, Integer page, Integer pagesize) {
        PageInfo<Advice> pageInfo = userService.selectAdviceByUser(userId, page, pagesize);
        if (pageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", pageInfo.getTotal()).add("pages", pageInfo.getPages())
                    .add("advices", pageInfo.getList()).toJsonObject();
        }
    }

    @PutMapping("/advice")
    public JSONObject updateAdviceStatus(Integer id) {
        if(userService.updateAdviceStatus(id)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }
}
