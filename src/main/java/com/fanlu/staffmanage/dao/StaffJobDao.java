package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffJob;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffJobDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffJob record);

    int insertSelective(StaffJob record);

    StaffJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffJob record);

    int updateByPrimaryKey(StaffJob record);
}