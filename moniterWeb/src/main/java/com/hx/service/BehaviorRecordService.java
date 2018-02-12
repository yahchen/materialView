package com.hx.service;

import com.hx.bean.BehaviorRecordParam;

import java.util.List;
import java.util.Map;

public interface BehaviorRecordService {
    public Map<String, Object> findRecordsByPage(BehaviorRecordParam behaviorRecordParam);

    //查询资料名称
    public List<Map<String, Object>> findMaterialName(BehaviorRecordParam behaviorRecordParam);

    //查询卫星名称
    public List<Map<String, Object>> findSatelliteName(BehaviorRecordParam behaviorRecordParam);
}
