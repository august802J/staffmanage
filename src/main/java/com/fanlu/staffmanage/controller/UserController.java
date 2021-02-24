package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 测试接口，发布将删除
     * @return
     */
    @GetMapping("/test")
    public String Test() {
        return "test success";
    }


    @PutMapping("/evaluation")
    public JSONObject updateStaff_evaluation(@RequestBody JSONObject evaluationMessageJson) {
        StaffEvaluation staffEvaluation =JSONObject.parseObject(evaluationMessageJson.toJSONString(), StaffEvaluation.class);
        StaffEvaluation staffEvaluation1=userService.updateStaff_evaluation(staffEvaluation);
        String staff_eva=JSONObject.toJSONString(staffEvaluation1);
        if(staff_eva.equals("")){
            return Message.fail().toJsonObject();
        }else{
            return Message.success().add("staffEvaluation",staff_eva).toJsonObject();
        }

    }

    @GetMapping("/evaluation")
    public JSONObject checkStaff_evaluation(int id) {
        StaffEvaluation staffEvaluation =userService.checkStaff_evaluation(id);
        String staff_eva=JSONObject.toJSONString(staffEvaluation);
        if(staff_eva.equals("")){
            return Message.fail().toJsonObject();
        }else{
            return Message.success().add("staffEvaluation",staff_eva).toJsonObject();
        }
    }

    @PostMapping("/evaluation")
    public JSONObject addStaff_evaluation(@RequestBody JSONObject evaluationMessageJson) {
        StaffEvaluation staffEvaluation =JSONObject.parseObject(evaluationMessageJson.toJSONString(), StaffEvaluation.class);
        StaffEvaluation staffEvaluation1 =userService.addStaff_evaluation(staffEvaluation);
        String staff_eva=JSONObject.toJSONString(staffEvaluation1);
        if(staff_eva.equals("")){
            return Message.fail().toJsonObject();
        }else{
            return Message.success().add("staffEvaluation",staff_eva).toJsonObject();
        }
    }

    @GetMapping("/staff")
    public JSONObject checkStaff(int id) {
        StaffInfo staffInfo=userService.checkStaff_info(id);
        StaffEvaluation staffEvaluation=userService.checkStaff_evaluation(id);
        StaffJob staffJob = userService.checkStaff_job(id);
        StaffAbility staffAbility=userService.checkStaff_ability(id);
        StaffEdu staffEdu=userService.checkStaff_edu(id);
        String staff_info=JSONObject.toJSONString(staffInfo);
        String staff_eva=JSONObject.toJSONString(staffEvaluation);
        String staff_abi=JSONObject.toJSONString(staffAbility);
        String staff_job=JSONObject.toJSONString(staffJob);
        String staff_edu=JSONObject.toJSONString(staffEdu);
        if(staff_info.equals("")){
            return Message.success().add("staffInfo",staff_info).add("staffEvaluation",staff_eva)
                    .add("staffJob",staff_job).add("staffAbility",staff_abi).add("staffEdu",staff_edu)
                    .toJsonObject();
        }else{
            return Message.fail().toJsonObject();
        }

    }

    @DeleteMapping("/staves")
    public JSONObject deleteStaff(int id) {
        if (userService.deleteStaff(id)) {
            return Message.success().toJsonObject();
        } else {
            return Message.fail().toJsonObject();
        }
    }

}
