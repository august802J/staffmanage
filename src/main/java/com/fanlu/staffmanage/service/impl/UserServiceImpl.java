package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.*;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Author: XijiaoZheng
 * @E-mail: 2516299639@qq.com
 * @Date: 2021/2/23 0:14
 * @Version: V1.0
 * @Description: 对该类的描述
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StaffEvaluationDao staffEvaluationDao;

    @Autowired
    private StaffInfoDao staffInfoDao;

    @Autowired
    private StaffJobDao staffJobDao;

    @Autowired
    private StaffEduDao staffEduDao;

    @Autowired
    private StaffAbilityDao staffAbilityDao;

    @Override
    public StaffEvaluation updateStaff_evaluation(StaffEvaluation staffEvaluation) {
        staffEvaluationDao.updateByPrimaryKey(staffEvaluation);
        return staffEvaluationDao.selectByPrimaryKey(staffEvaluation.getId());
    }

    @Override
    public StaffEvaluation checkStaff_evaluation(Integer id) {
        return staffEvaluationDao.selectByPrimaryKey(id);
    }

    @Override
    public StaffEvaluation addStaff_evaluation(StaffEvaluation staffEvaluation) {
        staffEvaluationDao.insert(staffEvaluation);
        return staffEvaluationDao.selectByPrimaryKey(staffEvaluation.getId());
    }

    @Override
    public boolean deleteStaff(Integer id) {
        return staffInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public StaffInfo checkStaff_info(Integer id) {
        return staffInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public StaffEdu checkStaff_edu(Integer id) {
        return staffEduDao.selectByPrimaryKey(id);
    }

    @Override
    public StaffJob checkStaff_job(Integer id) {
        return staffJobDao.selectByPrimaryKey(id);
    }

    @Override
    public StaffAbility checkStaff_ability(Integer id) {
        return staffAbilityDao.selectByPrimaryKey(id);
    }

}
