package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.UserCoopDao;
import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.UserCoop;
import com.fanlu.staffmanage.service.UserCoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YGwhere on 2021/2/20 17:08
 * Description: staffmanage
 *
 * @Author 15011_
 */
@Service
public class UserCoopServiceImpl implements UserCoopService {

    @Autowired
    private UserCoopDao userCoopDao;

    @Override
    public int addUserCoop(Inc inc) {
        UserCoop userCoop = new UserCoop(inc);
        userCoopDao.insertSelective(userCoop);
        return userCoop.getId();
    }
}
