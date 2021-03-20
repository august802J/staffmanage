package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.*;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.*;
import com.fanlu.staffmanage.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YGwhere on 2021/2/20 19:21
 * Description: staffmanage
 *
 * @Author 15011_
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service
public class SuperServiceImpl implements SuperService {
    @Autowired
    UserDao userDao;

    @Autowired
    StaffInfoDao staffInfoDao;

    @Autowired
    UserCoopDao userCoopDao;

    @Autowired
    FeedbackDao feedbackDao;

    @Autowired
    AdviceDao adviceDao;

    private static final String ORDER_BY_CHECK = "user_coop_isCheck asc";
    private static final String ORDER_BY_STATUS = "status asc";

    @Override
    public boolean addManager(String account, String password) {
        User user = new User(account, password);
        user.setAuth(3);
        int id = userDao.insertSelective(user);
        return id != 0;
    }

    @Override
    public Inc getIncDetail(int groupId) {
        UserCoop userCoop = userCoopDao.selectByPrimaryKey(groupId);
        if(null == userCoop) {
            return null;
        } else {
            return new Inc(userCoop);
        }
    }

    @Override
    public PageInfo<UserCoop> selectUserCoopInfoByPage(Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 5;
        }
        int total = (page - 1) * pagesize;
        int totalSql = userCoopDao.selectTotal();
        if(total > totalSql) {
            return null;
        }
        PageHelper.startPage(page, pagesize);
        List<UserCoop> userCoopList = userCoopDao.selectUserCooInfo();
        PageInfo<UserCoop> userCoopPageInfo = new PageInfo<>(userCoopList);
        userCoopPageInfo.setOrderBy(ORDER_BY_CHECK);
        return userCoopPageInfo;
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
    public int selectUserCount() {
        return userDao.selectUserCount();
    }

    @Override
    public boolean updateFeedbackStatus(Integer id) {
        return feedbackDao.updateStatusById(id);
    }

    @Override
    public PageInfo<Feedback> selectFeedbacksByUser(Integer userId, Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 8;
        }
        int total = (page - 1) * pagesize;
        int counts = feedbackDao.selectCount(userId);
        if(total > counts) {
            return null;
        }
        PageHelper.startPage(page, pagesize);
        List<Feedback> feedbacks = feedbackDao.selectByUserId(userId);
        PageInfo<Feedback> pageInfo = new PageInfo<>(feedbacks);
        pageInfo.setOrderBy(ORDER_BY_STATUS);
        return pageInfo;
    }

    @Override
    public boolean deleteFeedback(Integer feedId) {
        return feedbackDao.deleteByPrimaryKey(feedId) > 0;
    }

    @Override
    public boolean addAdvice(Integer groupId, Integer userId, String message) {
        List<Integer> recvs = userDao.selectUserByGroupId(groupId);
        if(recvs.isEmpty()) {
            return false;
        }
        for(Integer recv : recvs) {
            Advice advice = new Advice(recv, userId, message);
            adviceDao.insertSelective(advice);
        }
        return true;
    }

    @Override
    public boolean deleteAdvice(Integer id) {
        return adviceDao.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public PageInfo<Advice> selectAllAdvice(Integer page, Integer pagesize) {
        if(page == null) {
            page = 1;
        }
        if(pagesize == null) {
            pagesize = 10;
        }
        int total = (page - 1) * pagesize;
        int count = adviceDao.selectCount();
        if(total > count) {
            return null;
        }
        PageHelper.startPage(page, pagesize);
        List<Advice> advices = adviceDao.selectAllAdvice();
        PageInfo<Advice> advicePageInfo = new PageInfo<>(advices);
        advicePageInfo.setOrderBy(ORDER_BY_STATUS);
        return advicePageInfo;
    }
}
