package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffEdu;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffEduDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffEdu record);

    int insertSelective(StaffEdu record);

    StaffEdu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffEdu record);

    int updateByPrimaryKey(StaffEdu record);

    boolean deleteByStaffId(Integer staff_id);
}