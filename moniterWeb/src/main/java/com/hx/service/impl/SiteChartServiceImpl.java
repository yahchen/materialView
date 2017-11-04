package com.hx.service.impl;

import com.hx.dao.SiteChartDao;
import com.hx.service.SiteChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/31.
 */
@Service
public class SiteChartServiceImpl implements SiteChartService {

    @Autowired
    @Qualifier("siteChartDaoImpl")
    private SiteChartDao siteChartDao;

    @Override
    public List<Map<String, Object>> findSiteChartByTimeElement(String startTime, String endTime, String queryElment) {
        return siteChartDao.findSiteChartByTimeElement(startTime,endTime,queryElment);
    }
}
