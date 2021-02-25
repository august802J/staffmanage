package com.fanlu.staffmanage.service;

import com.fanlu.staffmanage.dto.Inc;
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
}
