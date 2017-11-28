package com.hx.dao.impl;

import com.hx.dao.FileChartDao;
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
public class FileChartDaoImpl implements FileChartDao {

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;




    @Override
    public List<Map<String, Object>> findSateFileSelectdByTimeElement(String startTime, String endTime,  String queryElment) {
        String sSQL = "select distinct sate_name from public.satellite_file_data_head sfdh where sfdh.data_time>='"+startTime+"' and sfdh.data_time<'"+endTime+"' and sfdh.data_logo = '"+queryElment+"';";
        List<Map<String, Object>> siteDataHeadList =  template.queryForList( sSQL);
        return siteDataHeadList;
    }

    @Override
    public List<Map<String, Object>> findSateFileChartByTimeElement(String startTime, String endTime, String queryElment, String sateFileName) {
        String sSQL = "select sfdh.data_time,sfdh.sate_file_num,sfdh.retrieve_process_time from public.satellite_file_data_head sfdh where sfdh.data_time>='"+startTime+"' and sfdh.data_time<'"+endTime+"' and sfdh.data_logo = '"+queryElment+"' and sfdh.sate_name='"+sateFileName+"' order by sfdh.data_time;";
        List<Map<String, Object>> siteDataHeadList =  template.queryForList( sSQL);
        return siteDataHeadList;
    }

    @Override
    public List<Map<String, Object>> findFileChartByTimeElement(String startTime, String endTime, String queryElment) {
        String sSQL = "select fdh.data_time,fdh.data_num,fdh.retrieve_process_time from public.file_data_head fdh where fdh.data_time>='"+startTime+"' and fdh.data_time<'"+endTime+"' and fdh.data_logo = '"+queryElment+"' order by fdh.data_time;";
        List<Map<String, Object>> fileDataHeadList =  template.queryForList( sSQL);
        return fileDataHeadList;
    }
}
