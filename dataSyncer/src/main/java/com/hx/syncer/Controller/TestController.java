package com.hx.syncer.Controller;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.service.GridDataHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by yahchen on 2017/10/29.
 */
@Controller
public class TestController {
    @Autowired
    private GridDataHeadService gridDataHeadService;

    @RequestMapping("/query")
    @ResponseBody
    public String query(){
        GridDataHeadDo entity = new GridDataHeadDo();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        entity.setData_code("232332");
        entity.setData_end_time(ts);
        entity.setData_logo("rese");
        entity.setData_name("sdfsds");
        entity.setData_num("sdfsd");
        entity.setData_start_time(ts);
        entity.setData_type(1);
        entity.setElements("");
        entity.setData_time(ts);
        entity.setFcstLevel("sds");
        entity.setFile_path("sdsd");
        entity.setG_d_id(2);
        entity.setGridfile_state("");
        entity.setGridfileNumMax(121);
        entity.setLongitude_latitude_scope("");
        entity.setRetrieve_end_time(ts);
        entity.setRetrieve_process_time(32323);
        entity.setRetrieve_start_time(ts);
        entity.setReturn_abnormal_info("sdsd");
        entity.setValidTime("sds");
        entity.setUser_id("sd");
        entity.setSystem_name("sdds");
        entity.setSite_type(2);
        entity.setSys_conn_state("sd");
        boolean resutl = gridDataHeadService.saveOne(entity);
        return "stkjlsdsd" + resutl;
    }
}
