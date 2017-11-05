package com.hx.syncer.fileHandler;

import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.CustomRepository;
import com.hx.syncer.service.GridDataHeadService;
import com.hx.syncer.service.SiteDataHeadService;
import com.hx.syncer.util.PropertiesReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class SiteDataTaskPool{
    @Autowired
    private GridDataHeadService gridDataHeadService;
    @Autowired
    private SiteDataHeadService siteDataHeadService;
    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private PropertiesReflectUtil propertiesReflectUtil;

    @Async
    public void asyncGmSiteSurfGlData(Path path) {
        List<String> proNames = new ArrayList<>();
        try {
            SiteDataHeadDo siteDataHeadDo = new SiteDataHeadDo();
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str = null;
            int i = 0;
            while ((str = reader.readLine()) != null) {
                String[] kv = str.split(":");
                System.out.println("---------------------"+kv[0]);
//                if(null == kv || 2 != kv.length)
//                    continue;
//                if(str.contains("element")){
//
//                }else{
//                    propertiesReflectUtil.autowiredProperty(siteDataHeadDo,siteDataHeadDo.getClass(),kv[0],kv[1]);
//                }






            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
