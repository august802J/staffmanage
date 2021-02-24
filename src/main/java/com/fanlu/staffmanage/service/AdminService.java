package com.fanlu.staffmanage.service;

/**
 * @ClassName: AdminService
 * @Author: XijiaoZheng
 * @E-mail: 2516299639@qq.com
 * @Date: 2021/2/23 0:46
 * @Version: V1.0
 * @Description: 对该类的描述
 */

public interface AdminService {
    boolean addAdmin(String account, String password);

    boolean deleteAdmin(int id);

}
