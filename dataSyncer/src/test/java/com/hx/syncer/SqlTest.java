package com.hx.syncer;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.dao.GridDataHeadDao;
import com.hx.syncer.service.GridDataHeadService;
import com.hx.syncer.util.DbUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yahchen on 2017/10/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlTest {
    @Autowired
    private GridDataHeadDao gridDataHeadDao;
    @Autowired
    private DbUtils dbUtils;

    @Test
    public void testBeanName() throws Exception{
        dbUtils.getTableEleBeanClassName("RSURF_PRE_3h");
    }

    @Test
    public void testSql(){
        Assert.notNull(gridDataHeadDao,"template is null");
        GridDataHeadDo entity = new GridDataHeadDo();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        entity.setData_code("232------------332");
        entity.setData_end_time(ts);
        entity.setData_logo("ressdfsdf--------------e");
        entity.setData_name("sd------------------fsds");
        entity.setData_num("sd-----------------fsd");
        entity.setData_start_time(ts);
        entity.setData_type(1);
        entity.setElements("");
        entity.setData_time(ts);
        entity.setFcstLevel("sds");
        entity.setFile_path("sdsd");
        entity.setGridfile_state("");
        entity.setLongitude_latitude_scope("");
        entity.setRetrieve_end_time(ts);
        entity.setRetrieve_process_time(32323);
        entity.setRetrieve_start_time(ts);
        entity.setReturn_abnormal_info("sdsd");
        entity.setValidTime("sds");
        entity.setUser_id("sd");
        entity.setSystem_name("sdds");
        entity.setMode_type(2);
        entity.setSys_conn_state("sd");
        entity.setId(3);
        GridDataHeadDo resutl = gridDataHeadDao.save(entity);
        System.out.println("id:--------"+resutl.getId());
        Assert.notNull(resutl);
    }

    @Test
    public void query(){
        List<GridDataHeadDo> ress = gridDataHeadDao.findAll();
        Assert.notNull(ress);
    }
}

