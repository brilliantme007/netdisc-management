package com.neitdisc.demo.repository;

import com.neitdisc.demo.entity.NetdiscInfo;
import com.neitdisc.demo.repository.dao.NetdiscInfoDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/8/21 11:45
 */
public interface NetdiscInfoRepositoryInter extends JpaRepository<NetdiscInfo, String>, NetdiscInfoDao {

    /**
     * 批量删除
     * @param guids guids
     * @return
     */
    long deleteAllByGuidIn(List<String> guids);

}
