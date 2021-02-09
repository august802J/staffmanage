package com.fanlu.staffmanage.mapper;

import com.fanlu.staffmanage.entity.User;

import java.util.List;

/**
 * Created by YGwhere on 2021/2/9 17:56
 * Description: staffmanage
 *
 * @Author 15011_
 */

public interface UserMapper {

    User getUserById(int id);

    User getUserByName(String name);

    List<User> getAllUsers();
}
