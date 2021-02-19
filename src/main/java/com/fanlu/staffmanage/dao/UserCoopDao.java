package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.UserCoop;

public interface UserCoopDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCoop record);

    int insertSelective(UserCoop record);

    UserCoop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCoop record);

    int updateByPrimaryKey(UserCoop record);
}