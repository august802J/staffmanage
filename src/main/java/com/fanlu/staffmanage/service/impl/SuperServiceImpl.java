package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.UserCoopDao;
import com.fanlu.staffmanage.dao.UserDao;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.entity.UserCoop;
import com.fanlu.staffmanage.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
