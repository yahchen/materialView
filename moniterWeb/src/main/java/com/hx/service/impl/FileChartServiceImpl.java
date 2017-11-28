package com.hx.service.impl;

import com.hx.dao.FileChartDao;
import com.hx.service.FileChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/31.
 */
@Service
public class FileChartServiceImpl implements FileChartService {

    @Autowired
    @Qualifier("fileChartDaoImpl")
    private FileChartDao fileChartDao;


    @Override
    public List<Map<String, Object>> findSateFileSelectdByTimeElement(String startTime, String endTime, String queryElment) {
        return fileChartDao.findSateFileSelectdByTimeElement(startTime,endTime,queryElment);
    }

    @Override
    public List<Map<String, Object>> findSateFileChartByTimeElement(String startTime, String endTime, String queryElment, String sateFileName) {
        return fileChartDao.findSateFileChartByTimeElement(startTime,endTime,queryElment,sateFileName);
    }

    @Override
    public List<Map<String, Object>> findFileChartByTimeElement(String startTime, String endTime, String queryElment) {
        return fileChartDao.findFileChartByTimeElement(startTime,endTime,queryElment);
    }
}
