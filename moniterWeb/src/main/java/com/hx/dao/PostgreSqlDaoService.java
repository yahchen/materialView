package com.hx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by yahchen on 2017/10/31.
 */
@Repository
public class PostgreSqlDaoService {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;

    public void find(){

    }
}
