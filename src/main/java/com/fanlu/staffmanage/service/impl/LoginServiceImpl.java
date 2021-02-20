package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.UserCoopDao;
import com.fanlu.staffmanage.dao.UserDao;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.entity.UserCoop;
import com.fanlu.staffmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YGwhere on 2021/2/20 17:01
 * Description: staffmanage
 *
 * @Author 15011_
 */
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
        return user.getId();
    }

    @Override
    public int checkUser(String account, String password) {
        String pwd = userDao.selectAccountAndPassword(account);
        if(!password.equals(pwd)) {
            return -1;
        } else {
            return userDao.selectIdByAccount(account);
        }
    }
}
