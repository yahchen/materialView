package com.hx.service.impl;

import com.hx.bean.BehaviorRecordParam;
import com.hx.dao.BehaviorRecordDao;
import com.hx.service.BehaviorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BehaviorRecordServiceImpl implements BehaviorRecordService {
    @Autowired
    @Qualifier("behaviorRecordDaoImpl")
    private BehaviorRecordDao behaviorRecordDao;

    @Override
    public Map<String, Object> findRecordsByPage(BehaviorRecordParam behaviorRecordParam) {
        return behaviorRecordDao.findRecordsByPage(behaviorRecordParam);
    }

    //查询资料名称
    public List<Map<String, Object>> findMaterialName(BehaviorRecordParam behaviorRecordParam) {
        return behaviorRecordDao.findMaterialName(behaviorRecordParam);
    }

    //查询卫星名称
    public List<Map<String, Object>> findSatelliteName(BehaviorRecordParam behaviorRecordParam) {
        return behaviorRecordDao.findSatelliteName(behaviorRecordParam);
    }
}
