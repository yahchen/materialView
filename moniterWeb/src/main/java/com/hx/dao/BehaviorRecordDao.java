package com.hx.dao;

import com.hx.bean.BehaviorRecordParam;
import com.hx.bean.GridDataHead;
import com.hx.bean.SiteDataHead;

import java.util.List;
import java.util.Map;

public interface BehaviorRecordDao {

    //根据materialType区分查的是哪个资料的行为记录  1、站点资料 2、格点资料 3、卫星资料 4、文件资料、
    public List<Map<String, Object>> findRecordByPage(BehaviorRecordParam behaviorRecordParam);

    //根据条件查询记录总数
    public Long findRecordSize(BehaviorRecordParam behaviorRecordParam);

    //根据materialType区分查的是哪个资料的行为记录  1、站点资料 2、格点资料 3、卫星资料 4、文件资料、
    public Map<String, Object> findRecordsByPage(BehaviorRecordParam behaviorRecordParam);
    //查询资料名称
    public List<Map<String, Object>> findMaterialName(BehaviorRecordParam behaviorRecordParam);

    //查询卫星名称
    public List<Map<String, Object>> findSatelliteName(BehaviorRecordParam behaviorRecordParam);
}
