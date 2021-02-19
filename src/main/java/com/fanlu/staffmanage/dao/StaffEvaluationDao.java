package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffEvaluation;

public interface StaffEvaluationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffEvaluation record);

    int insertSelective(StaffEvaluation record);

    StaffEvaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffEvaluation record);

    int updateByPrimaryKey(StaffEvaluation record);
}