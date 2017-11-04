package com.hx.service;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/31.
 */
public interface GridChartService {
    /**
     * 查询折线图数据
     * @param startTime
     * @param endTime
     * @param queryElment
     * @return
     */
    public List<Map<String, Object>> findGridChartByTimeElement(String startTime, String endTime, String queryElment);
}
