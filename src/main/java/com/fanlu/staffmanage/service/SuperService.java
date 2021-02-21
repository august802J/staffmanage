package com.fanlu.staffmanage.service;

import com.fanlu.staffmanage.dto.Inc;

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
}
