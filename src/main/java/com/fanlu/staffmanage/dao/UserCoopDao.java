package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.UserCoop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCoopDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCoop record);

    int insertSelective(UserCoop record);

    UserCoop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCoop record);

    int updateByPrimaryKey(UserCoop record);

    List<UserCoop> selectUserCooInfo();

    /**
     * 查询注册企业总数
     * @return
     */
    int selectTotal();

    List<Integer> selectIdByname(String name);
}