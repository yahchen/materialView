package com.hx.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
public interface SiteChartDao {

    /**
     * 查询折线图数据
     *
     * @param startTime
     * @param endTime
     * @param queryElment
     * @return
     */
    public List<Map<String, Object>> findSiteChartByTimeElement(String startTime, String endTime, String queryElment);
}
