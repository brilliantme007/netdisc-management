package com.neitdisc.demo.service;

import com.neitdisc.demo.entity.NetdiscInfo;
import com.neitdisc.demo.entity.pojo.Response;
import com.neitdisc.demo.repository.NetdiscInfoRepositoryInter;
import com.neitdisc.demo.util.EntityUtils;
import com.neitdisc.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author WHLiang
 * @date 2019/8/21 11:48
 */
@Service
public class NetdiscInfoService {

    private NetdiscInfoRepositoryInter netdiscInfoRepositoryInter;

    @Autowired
    public NetdiscInfoService(NetdiscInfoRepositoryInter netdiscInfoRepositoryInter) {
        this.netdiscInfoRepositoryInter = netdiscInfoRepositoryInter;
    }

    /**
     * 分页查询
     *
     * @param page     Pageabel
     * @param paramMap 查询条件(和 表的字段名一样就行了)
     * @return
     */
    public Page<NetdiscInfo> queryPage(Pageable page, Map<String, Object> paramMap) {
        return netdiscInfoRepositoryInter.pageQuery(page, paramMap);
    }

    @Transactional
    public Response deleteByIds(List<String> guids) {
        return Response.success("删除成功!删除" + netdiscInfoRepositoryInter.deleteAllByGuidIn(guids) + "条数据");
    }

    @Transactional
    public synchronized Response update(Map<String, Object> params) {
        try {
            Object o = EntityUtils.mapToEntity(params, NetdiscInfo.class);
            if (o != null) {
                NetdiscInfo o1 = (NetdiscInfo) o;
                if(!StringUtils.isEmpty(o1.getGuid())){
                    netdiscInfoRepositoryInter.save(o1);
                    return Response.success("更新成功!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.error("更新失败!");
    }

}
