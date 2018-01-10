package com.hx.syncer.fileHandler;

import com.hx.syncer.bean.GmSiteSurfGlDo;
import com.hx.syncer.bean.GmSiteTempGlDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.BaseRepository;
import com.hx.syncer.dao.GmSiteSurfGlDao;
import com.hx.syncer.dao.GmSiteTempGlDao;
import com.hx.syncer.service.GridDataHeadService;
import com.hx.syncer.service.SiteDataHeadService;
import com.hx.syncer.util.DataSyncerConstants;
import com.hx.syncer.util.DbUtils;
import com.hx.syncer.util.PropertiesReflectUtil;
import org.hibernate.engine.internal.JoinSequence;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class CommonDataTaskPool{
    @Autowired
    private PropertiesReflectUtil propertiesReflectUtil;
    @Autowired
    private DbUtils dbUtils;


    @Async
    public void asyncSaveCommonDbData(Path path) {
        try {
            BaseRepository baseRepository = null;
            Object dataHeadEntity = null;
            Pattern pattern = Pattern.compile("\\{|\\}");
            List<String> attrList = new ArrayList<>();
            Map<String,String> kvMap = new HashMap<>();
            List<String> fileNameList = new ArrayList<>();
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String str = null;
            while ((str = reader.readLine()) != null) {
                String[] kv = str.split(":",2);
                if(str.trim().equals("") || 2 != kv.length || pattern.matcher(str).find())
                    continue;
                if(kv[0].contains("elements_value")){
                    dataHeadEntity = baseRepository.save(dataHeadEntity);
                    String sdidV = propertiesReflectUtil.getFiledValue(dataHeadEntity,"s_d_id");
                    String dataLogoV = propertiesReflectUtil.getFiledValue(dataHeadEntity,"data_logo");
                    String[] rows = kv[1].replace("\"","").trim().split(";");
                    for(String row:rows){
                        asyncSaveElementData(row,attrList,sdidV,dataLogoV);
                    }
                    continue;
                }
                if(kv[0].contains("element")){
                    String[] attrs = kv[1].replace("\"","").trim().split(",");
                    for(int j = 0;j<attrs.length;j++){
                        attrList.add(attrs[j]);
                    }
                }if(kv[0].contains("file_name")){
                    String dataType = propertiesReflectUtil.getFiledValue(dataHeadEntity,"data_type");
                    if(!StringUtils.isEmpty(dataType) && Integer.valueOf(dataType) == DataSyncerConstants.FILEHEAD){
                        dbUtils.getTableHeadDao(dataType).save(dataHeadEntity);
                    }
                    String[] attrs = kv[1].replace("\"","").replace("{","").replace("}","").trim().split(",");
                    for(String fkv:attrs){
                        String[] fnPair = fkv.split(":");
                        if(fnPair[0].contains("count"))
                            continue;
                        String[] fnList = fnPair[1].split(";");
                        Collections.addAll(fileNameList,fnList);
                    }
                }else {
                    String name = kv[0].replace("\"","").trim();
                    String value = kv[1].replace("\"","").replace(",","").trim();
                    if(name.contains("data_type"))
                        dataHeadEntity = dbUtils.getTableHeadObj(value);

                }
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Async
    public void asyncSaveElementData(String row,List<String> attrList,String s_f_id,String logo){
        try{
            String[] vs = row.split(",");
            Object tableBeanObj = dbUtils.getTableEleBeanClassName(logo);
            propertiesReflectUtil.autowiredProperty(tableBeanObj,tableBeanObj.getClass(),"s_f_id",s_f_id);
            for(int k=0;k<vs.length;k++){
                propertiesReflectUtil.autowiredProperty(tableBeanObj,tableBeanObj.getClass(),attrList.get(k),vs[k]);
            }
            dbUtils.getTableEleDaoObj(logo).save(tableBeanObj);
        }catch (Exception e){

        }
    }
    @Async
    public void asyncSaveSateElementData() {

    }
}
