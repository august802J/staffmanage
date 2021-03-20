package com.fanlu.staffmanage.service;

import com.fanlu.staffmanage.dto.Inc;
import com.fanlu.staffmanage.entity.Advice;
import com.fanlu.staffmanage.entity.Feedback;
import com.fanlu.staffmanage.entity.StaffInfo;
import com.fanlu.staffmanage.entity.UserCoop;
import com.github.pagehelper.PageInfo;

/**
 * Created by YGwhere on 2021/2/20 19:12
 * Description: staffmanage
 *
 * @Author 15011_
 */
public interface SuperService {

    /**
     * 添加后台管理员
     * @param account
     * @param password
     * @return
     */
    boolean addManager(String account, String password);

    /**
     * 通过公司ID查询公司的具体信息
     * @param groupId
     * @return
     */
    Inc getIncDetail(int groupId);

    /**
     * 分页查询公司简介
     * @param page
     * @param pagesize
     * @return
     */
    PageInfo<UserCoop> selectUserCoopInfoByPage(Integer page, Integer pagesize);

    /**
     * 通过公司ID分页查询员工信息
     * @param groupId
     * @param page
     * @param pagesize
     * @return
     */
    PageInfo<StaffInfo> selectStaffInfoByPage(int groupId, Integer page, Integer pagesize);

    /**
     * 查询用户总数
     * @return
     */
    int selectUserCount();

    /**
     * 修改建议状态
     * @param id
     * @return
     */
    boolean updateFeedbackStatus(Integer id);

    /**
     * 通过用户id查询建议
     * @param userId
     * @return
     */
    PageInfo<Feedback> selectFeedbacksByUser(Integer userId, Integer page, Integer pagesize);

    /**
     * 删除反馈建议
     * @param feedId
     * @return
     */
    boolean deleteFeedback(Integer feedId);

    /**
     * 发布一条公告
     * @param groupId
     * @param userId
     * @param message
     * @return
     */
    boolean addAdvice(Integer groupId, Integer userId, String message);

    /**
     * 删除公告
     * @param id
     * @return
     */
    boolean deleteAdvice(Integer id);

    /**
     * 查询全部公告
     * @return
     */
    PageInfo<Advice> selectAllAdvice(Integer page, Integer pagesize);

}
