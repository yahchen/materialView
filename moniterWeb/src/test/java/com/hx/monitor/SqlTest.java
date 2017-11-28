package com.hx.monitor;

import com.hx.dao.GridMatrixDao;
import com.hx.dao.FileChartDao;
import com.hx.dao.SiteChartDao;
import com.hx.dao.PostgreSqlDao;
import com.hx.service.GridMatrixService;
import com.hx.service.SiteChartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.text.ParseException;
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
    private SiteChartService siteChartService;
    @Autowired
    private PostgreSqlDao postgreSqlDao;

    @Autowired
    @Qualifier("fileChartDaoImpl")
    private FileChartDao fileChartDao;

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
    public void testGm(){
        List<Map<String,Object>> res = postgreSqlDao.queryBinMapData("gm_site_surf_gl",null,"");
        assert res == null;
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

    @Test
    public void testFindSateFileSelectdByTimeElement(){
        String startTime ="2017-11-01 00:00:00";
        String endTime =("2017-11-20 23:59:59");
        List resutl = fileChartDao.findSateFileSelectdByTimeElement(startTime,endTime,"GM_RATVC_ATOVS");
        System.out.println(resutl.size());
    }

    @Test
    public void testFindSateFileChartByTimeElement(){
        String startTime ="2017-11-01 00:00:00";
        String endTime =("2017-11-20 23:59:59");
        List resutl = fileChartDao.findSateFileChartByTimeElement(startTime,endTime,"GM_RATVC_ATOVS","N15-AMSUA-BAWX");
        System.out.println(resutl.size());
    }
}
