package com.fanlu.staffmanage.dao;

import com.fanlu.staffmanage.entity.Advice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdviceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Advice record);

    int insertSelective(Advice record);

    Advice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKey(Advice record);

    /**
     * 查询全部公告
     * @return
     */
    List<Advice> selectAllAdvice();

    /**
     * 通过userId查询
     * @param recvId
     * @return
     */
    List<Advice> selectByRecvId(Integer recvId);

    /**
     * 修改通告状态
     * @param id
     * @return
     */
    int updateStatus(Integer id);

    /**
     * 查询全部公告数
     * @return
     */
    int selectCount();

    /**
     * 通过userId查询某个用户的公告数
     * @param recvId
     * @return
     */
    int selectCountByRecvId(Integer recvId);
}