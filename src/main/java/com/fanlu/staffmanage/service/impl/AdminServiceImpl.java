package com.fanlu.staffmanage.service.impl;

import com.fanlu.staffmanage.dao.UserDao;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AdminServiceImpl
 * @Author: XijiaoZheng
 * @E-mail: 2516299639@qq.com
 * @Date: 2021/2/23 0:46
 * @Version: V1.0
 * @Description: 对该类的描述
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean addAdmin(String account, String password) {
        User user=new User(account,password);
        int id=userDao.insertSelective(user);
        return id!=0;
    }

    @Override
    public boolean deleteAdmin(int id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
