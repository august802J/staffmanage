package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.*;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private UserDao userDao;

    @Autowired
    UserCoopDao userCoopDao;

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private AdviceDao adviceDao;

    private static final String ORDER_BY_STATUS = "status asc";

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
        return new PageInfo<>(staffInfoList);
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
        return new PageInfo<>(staffInfoList);
        return new PageInfo<>(staffInfoList);
    }

    @Override
    public boolean insertFeedback(String message, Integer userId) {
        Integer groupId = userDao.selectGroupIdByUserId(userId);
        if(groupId == null) {
            return false;
        }
        List<Integer> managers = userDao.selectManager();
        if(managers.isEmpty()) {
            return false;
        }
        for(int manager : managers) {
            Feedback feedback = new Feedback(manager, userId, groupId, message);
            feedbackDao.insertSelective(feedback);
        }
        return true;
    }

    @Override
    public PageInfo<StaffInfo> selectStaffInfoByName(String name, Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 9;
        }
        PageHelper.startPage(page, pagesize);
        List<StaffInfo> staffInfoList = staffInfoDao.selectStaffInfoByName(name);
        return new PageInfo<>(staffInfoList);
    }

    @Override
    public PageInfo<StaffInfo> selectAllStaffInfoByPage(Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 9;
        }
        PageHelper.startPage(page, pagesize);
        List<StaffInfo> staffInfoList = staffInfoDao.selectAllStaffs();
        return new PageInfo<>(staffInfoList);
    }

    @Override
    public boolean isTrue(Integer staffId, Integer id) {
        return staffInfoDao.selectGroupIdById(staffId) == userDao.selectGroupIdById(id);
    }

    @Override
    public PageInfo<StaffInfo> selectStaffInfoByinc(String name, Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 9;
        }
        PageHelper.startPage(page, pagesize);
        List<Integer> staffInc= userCoopDao.selectIdByname(name);
        List<StaffInfo> staffInfoList=new ArrayList<>();
        for(Integer incid : staffInc){
            staffInfoList.addAll(staffInfoDao.selectStaffInfoByGroupId(incid));
        }
        return new PageInfo<>(staffInfoList);
    }



    @Override
    public PageInfo<Advice> selectAdviceByUser(Integer userId, Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 10;
        }
        int total = (page - 1) * pagesize;
        int count = adviceDao.selectCountByRecvId(userId);
        if(total > count) {
            return null;
        }
        PageHelper.startPage(page, pagesize);
        List<Advice> advices = adviceDao.selectByRecvId(userId);
        PageInfo<Advice> advicePageInfo = new PageInfo<>(advices);
        advicePageInfo.setOrderBy(ORDER_BY_STATUS);
        return advicePageInfo;
    }

    @Override
    public boolean updateAdviceStatus(Integer id) {
        return adviceDao.updateStatus(id) > 0;
    }
}
