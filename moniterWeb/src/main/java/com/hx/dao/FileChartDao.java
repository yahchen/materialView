package com.hx.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
public interface FileChartDao {

    /**
     * 查询卫星文件下拉框中数据
     *
     * @param startTime
     * @param endTime
     * @param queryElment
     * @return
     */
    public List<Map<String, Object>> findSateFileSelectdByTimeElement(String startTime, String endTime, String queryElment);

    /**
     * 查询卫星文件数和相应时间
     *
     * @param startTime
     * @param endTime
     * @param queryElment
     * @return
     */
    public List<Map<String, Object>> findSateFileChartByTimeElement(String startTime, String endTime, String queryElment, String sateFileName);

    /**
     * 查询文件数和相应时间
     *
     * @param startTime
     * @param endTime
     * @param queryElment
     * @return
     */
    public List<Map<String, Object>> findFileChartByTimeElement(String startTime, String endTime, String queryElment);
}