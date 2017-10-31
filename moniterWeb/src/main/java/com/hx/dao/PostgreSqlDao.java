package com.hx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.thymeleaf.expression.Strings;

import java.sql.Timestamp;
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

    public List<Map<String,Object>> queryBinMapData(String table,Timestamp startTime, String qualiteType){
        String sql = "select * from " + table;
        if(!StringUtils.isEmpty(qualiteType) && !"0".equals(qualiteType))
            sql += "where " + qualiteType + " in(" + 0 + "," + 3 +"," + 4 + ")";
        return template.queryForList(sql);
    }
}
