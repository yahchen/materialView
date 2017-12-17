package com.hx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yahchen on 2017/10/31.
 */
@Repository
public class PostgreSqlDao {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;


    @Autowired
    @Qualifier("namedJdbcTemplate")
    private NamedParameterJdbcTemplate namedTemplate;

    public List<Map<String, Object>> queryBinMapData(String table, Timestamp startTime, String neLat, String neLon, String swLat, String swLon, String prs) {
        Map<String, Object> params = new HashMap<>();
        String sql = "select * from " + table + " where lat > :swLat AND lat < :neLat AND lon > :swLon AND lon < :neLon ";
        if (!StringUtils.isEmpty(prs)) {
            int prsInt = Integer.parseInt(prs);
            float start = 0, end = 100000;
            if (table.contains("temp")) {
                sql += "AND prs_hwc > :start AND prs_hwc < :end ";
            } else {
                sql += "AND prs > :start AND prs < :end ";
            }
            params.put("start", start);
            params.put("end", end);
        }
        sql += " limit :limitNum";
        params.put("limitNum", 1000);
        params.put("swLat", Float.valueOf(swLat));
        params.put("neLat", Float.valueOf(neLat));
        params.put("swLon", Float.valueOf(swLon));
        params.put("neLon", Float.valueOf(neLon));
        return namedTemplate.queryForList(sql, params);
    }

    public List<Map<String, Object>> queryBinQualiteTypeData(String table, String dataType) {
        String sql = "select * from " + table + " where data_logo_type = :dataType";
        Map<String, Object> params = new HashMap<>();
        params.put("dataType", dataType);
        return namedTemplate.queryForList(sql, params);
    }
}
