package com.hx.syncer.fileHandler;

import com.hx.syncer.bean.GmSiteSurfGlDo;
import com.hx.syncer.bean.GmSiteTempGlDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.GmSiteSurfGlDao;
import com.hx.syncer.dao.GmSiteTempGlDao;
import com.hx.syncer.service.GridDataHeadService;
import com.hx.syncer.service.SiteDataHeadService;
import com.hx.syncer.util.PropertiesReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class SiteDataTaskPool{
    @Autowired
    private SiteDataHeadService siteDataHeadService;
    @Autowired
    private GmSiteTempGlDao gmSiteTempGlDao;
    @Autowired
    private PropertiesReflectUtil propertiesReflectUtil;

    private AtomicLong atomId = new AtomicLong(1);
    private AtomicLong siteAtomId = new AtomicLong(1);
    private AtomicLong atomSid = new AtomicLong(100);


    @Async
    public void asyncGmSiteSurfGlData(Path path) {
        try {
            SiteDataHeadDo siteDataHeadDo = new SiteDataHeadDo();
            Pattern pattern = Pattern.compile("\\{|\\}");
            List<String> attrList = new ArrayList<>();
            atomSid.incrementAndGet();
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str = null;
            int i = 0;
            while ((str = reader.readLine()) != null) {
                String[] kv = str.split(":",2);
                if(str.trim().equals("") || 2 != kv.length || pattern.matcher(str).find())
                    continue;
                if(kv[0].contains("elements_value")){
//                    String[] rows = kv[1].replace("\"","").trim().split(";");
//                    for(String row:rows){
//                        asyncSaveSiteSurfData(row,attrList);
//                    }
                    continue;
                }
                if(kv[0].contains("element")){
                    String[] attrs = kv[1].replace("\"","").trim().split(",");
                    for(int j = 0;j<attrs.length;j++){
                        attrList.add(attrs[j]);
                    }
                }else {
                    String name = kv[0].replace("\"","").trim();
                    String value = kv[1].replace("\"","").replace(",","").trim();
                    propertiesReflectUtil.autowiredProperty(siteDataHeadDo,siteDataHeadDo.getClass(),name,value);
                }
            }
            siteDataHeadDo.setS_d_id(atomSid.get());
            siteDataHeadService.saveOne(siteDataHeadDo);
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Async
    public void asyncSaveSiteSurfData(String row,List<String> attrList){
        String[] vs = row.split(",");
        GmSiteTempGlDo gmSiteTempGlDo = new GmSiteTempGlDo();
        for(int k=0;k<vs.length;k++){
            propertiesReflectUtil.autowiredProperty(gmSiteTempGlDo,gmSiteTempGlDo.getClass(),attrList.get(k),vs[k]);
        }
        gmSiteTempGlDo.setId(atomId.incrementAndGet());
        gmSiteTempGlDo.setS_d_id(atomSid.get());
        gmSiteTempGlDao.save(gmSiteTempGlDo);
    }
}
