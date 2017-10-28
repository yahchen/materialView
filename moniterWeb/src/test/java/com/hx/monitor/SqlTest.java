package com.hx.monitor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

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
        resutl.forEach(e-> System.out.println("hahah:" + e.toString()));
        Assert.notNull(resutl);
    }
}
