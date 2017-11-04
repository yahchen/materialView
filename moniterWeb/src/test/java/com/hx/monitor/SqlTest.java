package com.hx.monitor;

import com.hx.bean.GridDataHead;
import com.hx.dao.GridMatrixDao;
import com.hx.dao.SiteChartDao;
import com.hx.service.GridMatrixService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyaohui on 2017/6/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlTest {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;

    @Autowired
    @Qualifier("gridMatrixDaoImpl")
    private GridMatrixDao gridMatrixDao;

    @Autowired
    @Qualifier("gridMatrixServiceImpl")
    private GridMatrixService gridMatrixService;

    @Autowired
    @Qualifier("siteChartDaoImpl")
    private SiteChartDao siteChartDao;

    @Autowired
    @Qualifier("siteChartServiceImpl")
    private SiteChartDao siteChartService;
    @Test
    public void testSql(){
        Assert.notNull(template,"template is null");
        List resutl = template.queryForList("select * from public.materia;");
        resutl.forEach(e-> System.out.println("hahah:" + e.toString()));
        Assert.notNull(resutl);
    }

    @Test
    public void testGridDataDao(){
        List resutl = template.queryForList("select * from public.grid_data_head;");
        System.out.println(resutl.size());
    }

    @Test
    public void testGridDataDaoImpl() throws ParseException {

        String startTime ="2017-10-13 00:00:00";
        System.out.println("---------------");
        String endTime =("2017-10-13 23:59:59");
        List<Map<String, Object>> gridDataHead = gridMatrixDao.findMatrixByTimeElement(startTime,endTime,"GRID_ECMWF_U");
        Map<String, Object> gridDataHeads =  gridDataHead.get(0);
        System.out.println(gridDataHeads.get("data_code"));
    }
    @Test
    public void testSiteChartDao(){
        String startTime ="2017-10-01 00:00:00";
        String endTime =("2017-10-20 23:59:59");
        List resutl = siteChartService.findSiteChartByTimeElement(startTime,endTime,"GM_RSURF_GL");
        System.out.println(resutl.size());
    }
}
