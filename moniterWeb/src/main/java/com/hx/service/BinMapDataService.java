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

    public List<Map<String,Object>> queryBinMapData(String table, Timestamp startTime, String qualiteType){
        return postgreSqlDao.queryBinMapData(table,startTime,qualiteType);
    }
}
