package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.StaffInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffInfoDao {
    boolean deleteByPrimaryKey(Integer id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    StaffInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);

    /**
     * 通过公司ID搜索公司员工
     * @param groupId
     * @return
     */
    List<StaffInfo> selectStaffInfoByGroupId(Integer groupId);

    /**
     * 通过公司ID查询该公司员工总数
     * @return
     */
    int selectTotal(Integer groupId);

    List<StaffInfo> selectStaffIsWork();

    List<StaffInfo> selectStaffInfoByName(String name);

    List<StaffInfo> selectAllStaffs();

    int selectGroupIdById(Integer id);
}