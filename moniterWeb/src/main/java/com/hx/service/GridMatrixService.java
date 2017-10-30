package com.hx.service;

import com.hx.bean.GridDataHead;

import javax.lang.model.element.NestingKind;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2017/10/29.
 */
public interface GridMatrixService {
    public List<Map<String, Object>> findMatrixByTimeElement(String startTime, String endTime, String queryElment);
}
