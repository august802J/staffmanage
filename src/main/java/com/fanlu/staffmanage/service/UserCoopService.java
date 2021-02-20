package com.fanlu.staffmanage.service;

import com.fanlu.staffmanage.dto.Inc;

/**
 * Created by YGwhere on 2021/2/20 17:06
 * Description: staffmanage
 *
 * @Author 15011_
 */
public interface UserCoopService {
    /**
     * 添加一个公司信息
     * @param inc
     * @return 公司信息 ID
     */
    int addUserCoop(Inc inc);

}
