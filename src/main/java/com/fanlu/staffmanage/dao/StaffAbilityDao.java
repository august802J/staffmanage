package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffAbility;

public interface StaffAbilityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffAbility record);

    int insertSelective(StaffAbility record);

    StaffAbility selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffAbility record);

    int updateByPrimaryKey(StaffAbility record);
}