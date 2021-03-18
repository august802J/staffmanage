package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffEvaluation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffEvaluationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffEvaluation record);

    int insertSelective(StaffEvaluation record);

    StaffEvaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffEvaluation record);

    int updateByPrimaryKey(StaffEvaluation record);

    int selectTotal(Integer id);

    List<StaffEvaluation> selectStaffEvalutionById(Integer staff_id);

    boolean deleteByStaffId(Integer staff_id);
}