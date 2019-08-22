package com.neitdisc.demo.repository;

import com.neitdisc.demo.entity.NetdiscInfo;
import com.neitdisc.demo.repository.dao.NetdiscInfoDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author WHLiang
 * @date 2019/8/21 15:10
 */
public class NetdiscInfoRepositoryInterImpl implements NetdiscInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<NetdiscInfo> pageQuery(Pageable pageable, Map<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT defineField FROM netdisc_info where 1=1 ");
        String needSelectFeilds = "GUID, SONGNAME, AUTHOR, FULLNAME, TYPE, SIZE, SLINK_LT, CHTIME_LT, YXQ_LT, " +
                "ZT_LT, SLINK_360, CHTIME_360, YXQ_360, ZT_360, SLINK_BD, CODE, CHTIME_BD, YXQ_BD, ZT_BD";

        List<String> existFeilds = Arrays.asList("GUID", "SONGNAME", "AUTHOR", "FULLNAME", "TYPE",
                "SIZE", "SLINK_LT", "CHTIME_LT", "YXQ_LT",
                "ZT_LT", "SLINK_360", "CHTIME_360", "YXQ_360",
                "ZT_360", "SLINK_BD", "CODE", "CHTIME_BD", "YXQ_BD", "ZT_BD");
        // params中作为like条件查询的字段
        List<String> likes = Arrays.asList("SONGNAME", "FULLNAME");
        // params中额外的不作为条件查询的字段
        List<String> neednotSet = null;
        //neednotSet = Arrays.asList("cstate","pubstate");
        // 拼接sql 条件
        addSql(sql, params, likes, neednotSet, existFeilds);

        Query queryCount = entityManager.createNativeQuery(sql.toString().replace("defineField",
                "COUNT(1)"));
        this.setParameters(queryCount, params, likes, neednotSet, existFeilds);
        //总条目数
        long count = Long.parseLong(queryCount.getSingleResult().toString());

        List<NetdiscInfo> netdiscInfos;
        if (count > 0) {
            Query query = entityManager.createNativeQuery(sql.toString()
                    .replace("defineField", needSelectFeilds), "resultMapping");
            this.setParameters(query, params, likes, neednotSet, existFeilds);

            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
            netdiscInfos = query.getResultList();
        } else {
            netdiscInfos = new ArrayList<>();
        }
        return new PageImpl<>(netdiscInfos, pageable, count);
    }

    /**
     * 拼接查询条件
     *
     * @param sql    sql
     * @param params params
     */
    private void addSql(StringBuilder sql, Map<String, Object> params, List<String> likes, List<String> needNotSet,
                        List<String> existFeilds) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (!StringUtils.isEmpty(entry.getValue())
                    && (needNotSet == null || !needNotSet.contains(entry.getKey()))
                    && existFeilds.contains(entry.getKey())) {
                if (likes == null || !likes.contains(entry.getKey())) {
                    sql.append("AND ").append(entry.getKey()).append(" = :").append(entry.getKey());
                } else {
                    sql.append("AND ").append(entry.getKey()).append(" LIKE :").append(entry.getKey());
                }
            }
        }
    }

    /**
     * 赋值sql参数
     *
     * @param query
     * @param paramMap
     * @param likes
     */
    private void setParameters(Query query, Map<String, Object> paramMap, List<String> likes, List<String> needNotSet,
                               List<String> existFeilds) {
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if (!StringUtils.isEmpty(entry.getValue())
                    && (needNotSet == null || !needNotSet.contains(entry.getKey()))
                    && existFeilds.contains(entry.getKey())) {
                if (likes == null || !likes.contains(entry.getKey())) {
                    query.setParameter(entry.getKey(), entry.getValue());
                } else {
                    query.setParameter(entry.getKey(), "%" + entry.getValue() + "%");
                }
            }
        }
    }

}
