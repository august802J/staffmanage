package com.fanlu.staffmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.UserService;
import com.fanlu.staffmanage.utils.Message;
import com.github.pagehelper.PageInfo;
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

//    /**
//     * 测试接口，发布将删除
//     * @return
//     */
//    @GetMapping("/test")
//    public String Test() {
//        return "test success";
//    }


    /*
     * 对方法的描述
     *
     修改指定者评价
     * @return
     * @throws
     */
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
    /*
     * 对方法的描述
     *
     查询多个评价
     * @return
     * @throws
     */
    @GetMapping("/evaluations")
    public JSONObject checkStaffs_evaluation(int id,int page,int pagesize) {
        if(Integer.valueOf(id)==null){
            return Message.fail(628,"请求格式错误").toJsonObject();
        }
        PageInfo<StaffEvaluation> staffEvaluationpageInfo =userService.selectStaff_evaByPage(id,page,pagesize);
        if(staffEvaluationpageInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            System.out.println(staffEvaluationpageInfo.getList());
            return Message.success().add("num", staffEvaluationpageInfo.getTotal())
                    .add("pages", staffEvaluationpageInfo.getPages()).add("result", staffEvaluationpageInfo.getList()).toJsonObject();
        }
    }
    /*
     * 对方法的描述
     *
     添加评论
     * @return
     * @throws
     */
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

    /*
     * 对方法的描述
     *
     得到员工详情页面
     * @return
     * @throws
     */
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
            return Message.fail().toJsonObject();
        }else{
            return Message.success().add("staffInfo",staff_info).add("staffEvaluation",staff_eva)
                .add("staffJob",staff_job).add("staffAbility",staff_abi).add("staffEdu",staff_edu)
                .toJsonObject();
        }
    }

    /*
     * 对方法的描述
     *
     删除本公司指定员工
     * @return
     * @throws
     */
    @DeleteMapping("/staves")
    public JSONObject deleteStaff(int id) {
        StaffInfo staffInfo=userService.checkStaff_info(id);
        String staff_info=JSONObject.toJSONString(staffInfo);
        if(staff_info.equals("")){
            return Message.fail().toJsonObject();
        } else {
            userService.deleteStaff_job(id);
            userService.deleteStaff_edu(id);
            userService.deleteStaff_ability(id);
            userService.deleteStaff_eva(id);
            if (userService.deleteStaff(id)) {
                return Message.success().toJsonObject();
            }else {
                return Message.fail().toJsonObject();
            }
        }
    }
    /*
     * 对方法的描述
     *
     查询多个本公司人员
     * @return
     * @throws
     */
    @GetMapping("/staves")
    public JSONObject getStaves(int id,int page,int pagesize){
        if(Integer.valueOf(id).equals("")){
            return Message.fail(628,"请求格式错误").toJsonObject();
        }
        PageInfo<StaffInfo> staffsInfo =userService.selectStaffInfoByPage(id,page, pagesize);
        if(staffsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", staffsInfo.getTotal())
                    .add("pages", staffsInfo.getPages()).add("result", staffsInfo.getList()).toJsonObject();
        }
    }
    /*
     * 对方法的描述
     * 
     查看本公司多个离职员工
     * @return 基本信息
     * @throws 
     */
    @GetMapping("/resigns")
    public JSONObject getResigns(Integer page,Integer pagesize) {
        PageInfo<StaffInfo> staff_ResignsInfo =userService.selectResignsByPage(page, pagesize);
        if(staff_ResignsInfo == null) {
            return Message.fail().toJsonObject();
        } else {
            return Message.success().add("num", staff_ResignsInfo.getTotal())
                    .add("pages", staff_ResignsInfo.getPages()).add("result", staff_ResignsInfo.getList()).toJsonObject();
        }
    }
}
