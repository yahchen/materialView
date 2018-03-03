package com.hx.service.impl;

import com.hx.dao.GridMatrixDao;
import com.hx.service.GridMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
@Service
public class GridMatrixServiceImpl implements GridMatrixService {
    @Autowired
    @Qualifier("gridMatrixDaoImpl")
    private GridMatrixDao gridMatrixDao;

    public List<Map<String, Object>> findMatrixByTimeElement(String startTime, String endTime, String queryElment) {

        return gridMatrixDao.findMatrixByTimeElement(startTime, endTime, queryElment);
    }
}
