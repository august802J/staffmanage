package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffEdu;

public interface StaffEduDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffEdu record);

    int insertSelective(StaffEdu record);

    StaffEdu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffEdu record);

    int updateByPrimaryKey(StaffEdu record);
}