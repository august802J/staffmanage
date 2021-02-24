package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffInfoDao {
    boolean deleteByPrimaryKey(Integer id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    StaffInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);
}