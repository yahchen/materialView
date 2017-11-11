package com.hx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.thymeleaf.expression.Maps;

import java.sql.Timestamp;
import java.util.*;

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

    public List<Map<String,Object>> queryBinMapData(String table,Timestamp startTime, String qualiteType){
        String sql = "select * from " + table;
        if(!StringUtils.isEmpty(qualiteType) && !"0".equals(qualiteType))
            sql += " where " + qualiteType + " in (:validVal)";
        sql += " limit :limitNum";
        List<Float> validVals = Arrays.asList(0f,3f,4f);
        Map<String,Object> params = new HashMap<>();
        params.put("validVal",validVals);
        params.put("limitNum",1000);
        return namedTemplate.queryForList(sql,params);
    }

    public List<Map<String,Object>> queryBinQualiteTypeData(String table, String dataType) {
        String sql = "select * from " + table + " where data_logo_type = :dataType";
        Map<String,Object> params = new HashMap<>();
        params.put("dataType",dataType);
        return namedTemplate.queryForList(sql,params);
    }
}
