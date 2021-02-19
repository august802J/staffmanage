package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffInfo;

public interface StaffInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    StaffInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);
}