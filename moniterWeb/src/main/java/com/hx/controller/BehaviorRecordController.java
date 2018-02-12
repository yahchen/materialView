package com.hx.controller;

import com.hx.bean.BehaviorRecordParam;
import com.hx.service.BehaviorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BehaviorRecordController {

    @Autowired
    @Qualifier("behaviorRecordServiceImpl")
    private BehaviorRecordService behaviorRecordService;

    @RequestMapping("/behavior_record_view")//对应url
    public String behaviorRecordView() {
        return "behavior/behavior_record";
    }

    @RequestMapping("/findRecordsByPage")//对应url
    @ResponseBody
    public Map<String, Object> findRecordsByPage(HttpServletRequest request) {

        BehaviorRecordParam behaviorRecordParam = new BehaviorRecordParam();
        behaviorRecordParam.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        behaviorRecordParam.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
        behaviorRecordParam.setModeType(request.getParameter("modeType"));
        behaviorRecordParam.setStartTime(request.getParameter("startTime"));
        behaviorRecordParam.setEndTime(request.getParameter("endTime"));
        behaviorRecordParam.setMaterialType(request.getParameter("materialType"));
        behaviorRecordParam.setMaterialName(request.getParameter("materialName"));
        behaviorRecordParam.setSateName(request.getParameter("sateName"));
        behaviorRecordParam.setTimeConsumeIndex(request.getParameter("timeConsumeIndex"));
        behaviorRecordParam.setTimeConsume(request.getParameter("timeConsume"));
        behaviorRecordParam.setSuccFail(request.getParameter("succFail"));

        Map<String, Object> map = behaviorRecordService.findRecordsByPage(behaviorRecordParam);

        return map;
    }

    @RequestMapping("/findMaterialName")//对应url
    @ResponseBody
    public Map<String, Object> findMaterialName(HttpServletRequest request) {

        BehaviorRecordParam behaviorRecordParam = new BehaviorRecordParam();
        behaviorRecordParam.setModeType(request.getParameter("modeType"));
        behaviorRecordParam.setStartTime(request.getParameter("startTime"));
        behaviorRecordParam.setEndTime(request.getParameter("endTime"));
        behaviorRecordParam.setMaterialType(request.getParameter("materialType"));
        behaviorRecordParam.setTimeConsumeIndex(request.getParameter("timeConsumeIndex"));
        behaviorRecordParam.setTimeConsume(request.getParameter("timeConsume"));
        behaviorRecordParam.setSuccFail(request.getParameter("succFail"));

        List list = behaviorRecordService.findMaterialName(behaviorRecordParam);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }

    @RequestMapping("/findSatelliteName")//对应url
    @ResponseBody
    public Map<String, Object> findSatelliteName(HttpServletRequest request) {

        BehaviorRecordParam behaviorRecordParam = new BehaviorRecordParam();
        behaviorRecordParam.setModeType(request.getParameter("modeType"));
        behaviorRecordParam.setStartTime(request.getParameter("startTime"));
        behaviorRecordParam.setEndTime(request.getParameter("endTime"));
        behaviorRecordParam.setMaterialType(request.getParameter("materialType"));
        behaviorRecordParam.setMaterialName(request.getParameter("materialName"));
        behaviorRecordParam.setTimeConsumeIndex(request.getParameter("timeConsumeIndex"));
        behaviorRecordParam.setTimeConsume(request.getParameter("timeConsume"));
        behaviorRecordParam.setSuccFail(request.getParameter("succFail"));

        List list = behaviorRecordService.findSatelliteName(behaviorRecordParam);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }

}
