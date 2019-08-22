package com.neitdisc.demo.repository.dao;

import com.neitdisc.demo.entity.NetdiscInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author WHLiang
 * @date 2019/8/21 15:06
 */
public interface NetdiscInfoDao {
    Page<NetdiscInfo> pageQuery(Pageable pageable, Map<String,Object> params);
}
