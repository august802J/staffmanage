package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.StaffInfoDao;
import com.fanlu.staffmanage.dao.UserCoopDao;
import com.fanlu.staffmanage.dao.UserDao;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.StaffInfo;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.entity.UserCoop;
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

    private static final String ORDER_BY_CHECK = "user_coop_isCheck asc";

    @Autowired
    UserCoopDao userCoopDao;

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
        PageInfo<StaffInfo> staffInfoPageInfo = new PageInfo<>(staffInfoList);
        return staffInfoPageInfo;
    }
}
