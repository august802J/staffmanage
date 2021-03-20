package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.UserCoopDao;
import com.fanlu.staffmanage.dao.UserDao;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.dto.Status;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.entity.UserCoop;
import com.fanlu.staffmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YGwhere on 2021/2/20 17:01
 * Description: staffmanage
 *
 * @Author 15011_
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCoopDao userCoopDao;

    @Override
    public int addUserCoop(Inc inc) {
        UserCoop userCoop = new UserCoop(inc);
        userCoopDao.insertSelective(userCoop);
        Status.plusInc();
        return userCoop.getId();
    }

    @Override
    public boolean updatePassword(String account, String newPassword) {
        int id = userDao.selectIdByAccount(account);
        if(id == -1) {
            return false;
        }
        return userDao.updatePasswordById(id, newPassword);
    }

    @Override
    public boolean checkIsAccount(String account) {
        int id = userDao.selectIdByAccount(account);
        return id != -1;
    }

    @Override
    public int addUser(User user, Inc inc) {
        int groupId = addUserCoop(inc);
        user.setGroupId(groupId);
        userDao.insertSelective(user);
        Status.plusUsers();
        return user.getId();
    }

    @Override
    public String checkUser(String account) {
        String pwd = userDao.selectAccountAndPassword(account);
        if(null == pwd || "".equals(pwd)) {
            return null;
        } else {
            return pwd;
        }
    }

    @Override
    public int checkUserAuth(String account) {
        return userDao.selectAuthByAccount(account);
    }
}
