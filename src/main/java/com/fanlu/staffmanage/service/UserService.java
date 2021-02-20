package com.fanlu.staffmanage.service;

import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.User;
import com.fanlu.staffmanage.entity.UserCoop;

/**
 * Created by YGwhere on 2021/2/20 16:51
 * Description: staffmanage
 *
 * @Author 15011_
 */
public interface UserService {
    /**
     * 通过账号修改密码
     * @param account
     * @param newPassword
     * @return
     */
    boolean updatePassword(String account, String newPassword);
    /**
     * 查询账号是否存在
     * @param account
     * @return
     */
    boolean checkIsAccount(String account);

    /**
     * 添加一个用户
     * @param user
     * @param inc
     * @return
     */
    int addUser(User user, Inc inc);

    /**
     * 验证账号与密码是否对应
     * @param account
     * @param password
     * @return
     */
    int checkUser(String account, String password);
}
