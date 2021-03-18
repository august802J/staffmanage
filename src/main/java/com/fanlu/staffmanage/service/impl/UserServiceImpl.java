package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.*;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean deleteStaff_eva(Integer staff_id) {
        return staffEvaluationDao.deleteByStaffId(staff_id);
    }

    @Override
    public boolean deleteStaff_job(Integer staff_id) {
        return staffJobDao.deleteByStaffId(staff_id);
    }

    @Override
    public boolean deleteStaff_edu(Integer staff_id) {
        return staffEduDao.deleteByStaffId(staff_id);
    }

    @Override
    public boolean deleteStaff_ability(Integer staff_id) {
        return staffAbilityDao.deleteByStaffId(staff_id);
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

    @Override
    public PageInfo<StaffEvaluation> selectStaff_evaByPage(int staff_id, Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 9;
        }
        int total = (page - 1) * pagesize;
        int totalSql = staffEvaluationDao.selectTotal(staff_id);
        if(total > totalSql) {
            return null;
        }
        if(totalSql==0){
            return null;
        }
        System.out.println(totalSql);
        PageHelper.startPage(page, pagesize);
        List<StaffEvaluation> staffEvaluationInfoList = staffEvaluationDao.selectStaffEvalutionById(staff_id);
        PageInfo<StaffEvaluation> staffEvaPageInfo = new PageInfo<>(staffEvaluationInfoList);
        return staffEvaPageInfo;
    }

    @Override
    public PageInfo<StaffInfo> selectStaffInfoByPage(int groupId, Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 9;
        }
        int total = (page - 1) * pagesize;
        int totalSql = staffInfoDao.selectTotal(groupId);
        if(total > totalSql) {
            return null;
        }
        PageHelper.startPage(page, pagesize);
        List<StaffInfo> staffInfoList = staffInfoDao.selectStaffInfoByGroupId(groupId);
        PageInfo<StaffInfo> staffInfoPageInfo = new PageInfo<>(staffInfoList);
        return staffInfoPageInfo;
    }

    @Override
    public PageInfo<StaffInfo> selectResignsByPage(Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 9;
        }
        PageHelper.startPage(page, pagesize);
        List<StaffInfo> staffInfoList = staffInfoDao.selectStaffIsWork();
        PageInfo<StaffInfo> staffInfoPageInfo = new PageInfo<>(staffInfoList);
        return staffInfoPageInfo;
    }

}
