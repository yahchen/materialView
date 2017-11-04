package com.hx.dao.impl;

import com.hx.bean.GridDataHead;
import com.hx.dao.GridMatrixDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
@Repository
public class GridMatrixDaoImpl implements GridMatrixDao {

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;

    @Override
    public List<Map<String, Object>> findMatrixByTimeElement(String startTime, String endTime, String queryElment) {
        String sSQL = "select * from public.grid_data_head gd where gd.data_time>='"+startTime+"' and gd.data_time<'"+endTime+"' and gd.data_logo = '"+queryElment+"';";

        //RowMapper<GridDataHead> rm = BeanPropertyRowMapper.newInstance(GridDataHead.class);
        //GridDataHead gridDataHead = (GridDataHead) this.template.queryForObject( sSQL, rm);
        List<Map<String, Object>> gridDataHeadList =  template.queryForList( sSQL);
        return gridDataHeadList;

    }
}
