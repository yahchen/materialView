package com.hx.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
public interface GridMatrixDao {

    /**
     * 查询矩阵图数据
     *
     * @param startTime
     * @param endTime
     * @param queryElment
     * @return
     */
    public List<Map<String, Object>> findMatrixByTimeElement(String startTime, String endTime, String queryElment);
}
