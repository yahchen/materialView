package com.hx.dao.impl;

import com.hx.dao.GridChartDao;
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
public class GridChartDaoImpl implements GridChartDao {

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;


    @Override
    public List<Map<String, Object>> findGridChartByTimeElement(String startTime, String endTime,  String queryElment) {
        String sSQL = "select * from public.grid_data_head gd where gd.data_time>='"+startTime+"' and gd.data_time<'"+endTime+"' and gd.data_logo = '"+queryElment+"' order by gd.data_time;";
        List<Map<String, Object>> gridDataHeadList =  template.queryForList( sSQL);
        return gridDataHeadList;
    }
}
