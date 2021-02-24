package com.fanlu.staffmanage.service;

import com.fanlu.staffmanage.entity.*;

/**
 * @ClassName: UserService
 * @Author: XijiaoZheng
 * @E-mail: 2516299639@qq.com
 * @Date: 2021/2/23 0:13
 * @Version: V1.0
 * @Description: 对该类的描述
 */

public interface UserService {

    //修改指定管理者评价
    StaffEvaluation updateStaff_evaluation(StaffEvaluation staffEvaluation);

    //查询指定管理者评价
    StaffEvaluation checkStaff_evaluation(Integer id);

    //添加指定管理者评价
    StaffEvaluation addStaff_evaluation(StaffEvaluation staffEvaluation);

    //删除指定员工资料
    boolean deleteStaff(Integer id);

    //查询单个员工详细页面
    StaffInfo checkStaff_info(Integer id);

    StaffEdu checkStaff_edu(Integer id);

    StaffJob checkStaff_job(Integer id);

    StaffAbility checkStaff_ability(Integer id);



    //查询多条管理员评价
    //String checkStaff_evaluations();

    //查询多个本公司人员
    //String checkStaffs();

    //查询多个离职人员
    //
}
