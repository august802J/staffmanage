package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    /**
     * 通过id将status改为1
     * @param id
     * @return
     */
    boolean updateStatusById(Integer id);

    List<Feedback> selectByUserId(Integer userId);

    int selectCount(Integer userId);
}