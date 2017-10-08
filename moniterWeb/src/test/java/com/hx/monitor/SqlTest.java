package com.hx.monitor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyaohui on 2017/6/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlTest {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;

    @Test
    public void testSql(){
        Assert.notNull(template,"template is null");
        List resutl = template.queryForList("select * from public.materia;");
        Assert.notNull(resutl);
    }
}
