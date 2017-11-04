package com.hx.dao.impl;

import com.hx.dao.GridMatrixDao;
import com.hx.dao.SiteChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
@Repository
public class SiteChartDaoImpl implements SiteChartDao {

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;


    @Override
    public List<Map<String, Object>> findSiteChartByTimeElement(String startTime, String endTime,  String queryElment) {
        String sSQL = "select * from public.site_data_head sd where sd.data_time>='"+startTime+"' and sd.data_time<'"+endTime+"' and sd.data_logo = '"+queryElment+"' order by sd.data_time;";
        List<Map<String, Object>> siteDataHeadList =  template.queryForList( sSQL);
        return siteDataHeadList;
    }
}
