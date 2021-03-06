package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 15011_
 */
@Repository
public interface UserDao {
    /**
     * 通过主键删除
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 插入一条用户信息
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 插入部分用户信息
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 通过主键查询用户信息
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 通过主键修改部分用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 通过主键修改全部用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过主键修改用户权限
     * @param id
     * @param auth
     * @return
     */
    boolean updateAuthByPrimaryKey(@Param("id") Integer id, @Param("auth") Integer auth);

    /**
     * 通过查询账号ID验证账号是否存在
     * @param account
     * @return
     */
    int selectIdByAccount(String account);

    /**
     * 通过账号查询密码
     * @param account
     * @return
     */
    String selectAccountAndPassword(String account);

    /**
     * 通过主键修改密码
     * @param id
     * @param password
     * @return
     */
    boolean updatePasswordById(Integer id, String password);

    /**
     * 通过账号搜索权限
     * @param account
     * @return
     */
    int selectAuthByAccount(String account);

    /*
     * 对方法的描述
     *
     通过ID查找公司id
     * @return
     * @throws
     */
    int selectGroupIdById(Integer id);


    /**
     * 查询用户数量
     * @return
     */
    int selectUserCount();

    /**
     * 查询用户的企业id
     * @param id
     * @return
     */
    Integer selectGroupIdByUserId(Integer id);

    /**
     * 通过企业id查询其所有用户
     * @param groupId
     * @return
     */
    List<Integer> selectUserByGroupId(Integer groupId);

    /**
     * 查询后台管理员
     * @return
     */
    List<Integer> selectManager();
}