package com.hx.service;

import com.hx.dao.PostgreSqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by yahchen on 2017/10/31.
 */
@Service
public class BinMapDataService {
    @Autowired
    private PostgreSqlDao postgreSqlDao;

    public List<Map<String,Object>> queryBinMapData(String table, Timestamp startTime,String neLat,String neLon,String swLat,String swLon,String prs){
        return postgreSqlDao.queryBinMapData(table,startTime,neLat,neLon,swLat,swLon,prs);
    }

    public List<Map<String,Object>> queryBinQualiteTypeData(String table, String dataType){
        return postgreSqlDao.queryBinQualiteTypeData(table,dataType);
    }

    public List<Map<String,Object>> querySatelliteTimeRangeBinMapData(String table,  String querySatelliteDate){
        return postgreSqlDao.querySatelliteTimeRangeBinMapData(table,querySatelliteDate);
    }
    public List<Map<String,Object>> querySatelliteBinMapData(String table, Timestamp stDate, String querySatelliteTime){
        return postgreSqlDao.querySatelliteBinMapData(table, stDate, querySatelliteTime);
    }

}
