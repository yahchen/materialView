package com.hx.syncer.fileHandler;

import com.hx.syncer.service.SateDataBinFileService;
import com.hx.syncer.util.DataSyncerConstants;
import com.hx.syncer.util.DbUtils;
import com.hx.syncer.util.PropertiesReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class CommonDataTaskPool{
    @Autowired
    private PropertiesReflectUtil propertiesReflectUtil;
    @Autowired
    private SateDataBinFileService sateDataBinFileService;
    @Autowired
    private DbUtils dbUtils;
    @Value("${spring.inbound.path}")
    private String inBoundFilePath;


    @Async
    public void asyncSaveCommonDbData(Path path) {
        try {
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
                if(kv[0].contains("elements_value")){//站点数据入库
                    if(null != dataHeadEntity){
                        String outId = propertiesReflectUtil.getFiledValue(dataHeadEntity,"id");
                        String dataLogoV = kvMap.get("data_logo");
                        String[] rows = kv[1].replace("\"","").trim().split(";");
                        for(String row:rows){
                            asyncSaveElementData(row,attrList,outId,dataLogoV,kvMap.get("data_type"));
                        }
                    }
                    continue;
                }
                if(kv[0].contains("element")){
                    String[] attrs = kv[1].replace("\"","").trim().split(",");
                    for(int j = 0;j<attrs.length;j++){
                        attrList.add(attrs[j]);
                    }
                }
                if(kv[0].contains("file_name")) {
                    continue;
                }
                if(kv[0].contains("-") && kv[1].contains(".BIN")){//卫星数据入库
                    String sateName = kv[0].replace("\"","").replace("{","").replace("}","").trim();
                    kvMap.put("sate_name",sateName);
                    String[] attrs = kv[1].replace("\"","").replace("{","").replace("}","").trim().split(";");
                    for(String fkv:attrs){
                        fileNameList.add(fkv);
                    }
                }else {
                    String name = kv[0].replace("\"","").trim();
                    boolean isSyncSplitRecord = name.contains("-count") && Integer.valueOf(kvMap.get("data_type")) == DataSyncerConstants.SATEFILEHEAD;
                    if(isSyncSplitRecord){
                        name = "sate_file_num";
                    }
                    String value = null;
                    if(name.contains("validTime") || name.contains("fcstLevel") || name.contains("longitude_latitude_scope") || name.contains("gridfile_state")){
                        value = kv[1].replace("\"", "").trim();
                        if(value.equals(","))
                            value = "";
                        else{
                            int dotIndex = value.lastIndexOf(",");
                            if(!StringUtils.isEmpty(value) && dotIndex > 0) {
                                value = value.substring(0, dotIndex);
                            }
                        }
                    }else {
                        value = kv[1].replace("\"", "").replace(",", "").trim();
                    }
                    if(name.contains("return_abnormal_info")){
                        generateAndPutGridPropertyValue("return_abnormal_info",value,kvMap,"#");
                    }else if(name.contains("gridfile_state")){
                        generateAndPutGridPropertyValue("gridfile_state",value,kvMap,";");
                    }else{
                        kvMap.put(name,value);
                    }
                    if(name.contains("mode_type") && kvMap.containsKey("data_type") && Integer.valueOf(kvMap.get("data_type")) != DataSyncerConstants.SATEFILEHEAD) {
                        dataHeadEntity = dbUtils.getTableHeadObj(kvMap.get("data_type"));
                        if(dataHeadEntity != null){
                            Iterator<Map.Entry<String,String>> iterator = kvMap.entrySet().iterator();
                            while (iterator.hasNext()){
                                Map.Entry<String,String> entry = iterator.next();
                                propertiesReflectUtil.autowiredProperty(dataHeadEntity,dataHeadEntity.getClass(),entry.getKey(),entry.getValue());
                            }
                            dataHeadEntity = dbUtils.getTableHeadDao(kvMap.get("data_type")).save(dataHeadEntity);//表头数据入库
                        }
                    }
                    if(isSyncSplitRecord){
                        dataHeadEntity = dbUtils.getTableHeadObj(kvMap.get("data_type"));
                        if(dataHeadEntity != null){
                            Iterator<Map.Entry<String,String>> iterator = kvMap.entrySet().iterator();
                            while (iterator.hasNext()){
                                Map.Entry<String,String> entry = iterator.next();
                                propertiesReflectUtil.autowiredProperty(dataHeadEntity,dataHeadEntity.getClass(),entry.getKey(),entry.getValue());
                            }
                            dataHeadEntity = dbUtils.getTableHeadDao(kvMap.get("data_type")).save(dataHeadEntity);//表头数据入库
                        }
                        if(null != dataHeadEntity && !fileNameList.isEmpty()){
                            asyncSaveSateElementData(kvMap.get("file_path"),fileNameList,propertiesReflectUtil.getFiledValue(dataHeadEntity,"id"));
                            fileNameList = new ArrayList<>();
                        }
                    }
                }
            }
            reader.close();
            Files.delete(path);//删除文件
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * 站点数据入库
     * @param row
     * @param attrList
     * @param outId
     * @param logo
     */
    @Async
    public void asyncSaveElementData(String row,List<String> attrList,String outId,String logo,String dataType){
        try{
            String[] vs = row.split(",");
            Object tableBeanObj = dbUtils.getTableEleBeanClassName(logo);
            propertiesReflectUtil.autowiredProperty(tableBeanObj,tableBeanObj.getClass(),dbUtils.getOutIdName(dataType),outId);
            for(int k=0;k<vs.length;k++){
                propertiesReflectUtil.autowiredProperty(tableBeanObj,tableBeanObj.getClass(),attrList.get(k),vs[k]);
            }
            dbUtils.getTableEleDaoObj(logo).save(tableBeanObj);
        }catch (Exception e){

        }
    }

    /**
     * 卫星数据文件扫描
     * @param path
     * @param fnList
     * @param sfId
     */
    @Async
    public void asyncSaveSateElementData(String path,List<String> fnList,String sfId) {
        List<Path> result = new LinkedList<Path>();
        try {
            String sateFilePath = path.startsWith(".")?inBoundFilePath + path.replace(".",""):path;
            Files.walkFileTree(Paths.get(sateFilePath),new SateDataFileVistor(result,fnList));
            for(Path satePath:result){
                asyncSaveSateBinFile(satePath,sfId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 卫星数据入库
     * @param satePath
     * @param sfId
     */
    @Async
    public void asyncSaveSateBinFile(Path satePath,String sfId) {
        DataSyncerConstants.FILTERFILENAMEMAP.forEach((fnameLogo,tableName)->{
            if(satePath.toString().contains(fnameLogo)){
                sateDataBinFileService.readAndSaveFileBin(tableName,sfId,satePath);
            }
        });
    }

    public void generateAndPutGridPropertyValue(String speciaKey,String currentValue,Map<String,String> kvMap,String splitSymbol){
        if(kvMap.containsKey(speciaKey)){
            kvMap.put(speciaKey,kvMap.get(speciaKey) + splitSymbol + currentValue);
        }else {
            kvMap.put(speciaKey,currentValue);
        }
    }
}
