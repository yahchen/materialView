package com.hx.service.impl;

import com.hx.dao.GridChartDao;
import com.hx.service.GridChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/31.
 */
@Service
public class GridChartServiceImpl implements GridChartService {

    @Autowired
    @Qualifier("gridChartDaoImpl")
    private GridChartDao gridChartDao;

    @Override
    public List<Map<String, Object>> findGridChartByTimeElement(String startTime, String endTime, String queryElment) {
        return gridChartDao.findGridChartByTimeElement(startTime, endTime, queryElment);
    }
}
