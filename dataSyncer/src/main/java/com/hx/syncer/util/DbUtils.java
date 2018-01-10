package com.hx.syncer.util;

import com.hx.syncer.bean.FileDataHeadDo;
import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.BaseRepository;
import com.hx.syncer.dao.GridDataHeadDao;
import com.hx.syncer.dao.SiteDataHeadDao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by yahchen on 2018/1/6.
 */
@Service
public class DbUtils implements ApplicationContextAware {

    /**
     * 上下文对象实例
     */
    private ApplicationContext applicationContext;


    public BaseRepository getTableEleDaoObj(String logo){
        if(StringUtils.isEmpty(logo))
            return null;
        String[] sameFactors = logo.split("_");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        int maxSimilarityValue = 0;
        String className = null;
        for(String name:beanNames){
            int curSimilarityValue = 0;
            if(name.contains("Dao")){
                for(String factor:sameFactors){
                    if(name.contains(factor))
                        curSimilarityValue++;
                }
                if(maxSimilarityValue < curSimilarityValue){
                    maxSimilarityValue = curSimilarityValue;
                    className = name;
                }
            }
        }
        return null == className?null:(BaseRepository)applicationContext.getBean(className);
    }

    public Object getTableEleBeanClassName(String logo) throws Exception{
        if(StringUtils.isEmpty(logo))
            return logo;
        String[] sameFactors = logo.split("_");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        int maxSimilarityValue = 0;
        String className = null;
        for(String name:beanNames){
            int curSimilarityValue = 0;
            if(name.contains("Dao")){
                for(String factor:sameFactors){
                    if(name.contains(factor))
                        curSimilarityValue++;
                }
                if(maxSimilarityValue < curSimilarityValue){
                    maxSimilarityValue = curSimilarityValue;
                    className = "com.hx.syncer."+name.replace("Dao","Do");
                }
            }
        }
        return null == className?null:Class.forName(className).newInstance();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object getTableHeadObj(String dataTypeValue) {
        if(StringUtils.isEmpty(dataTypeValue))
            return null;
        Object tableHeadObj = null;
        switch (Integer.valueOf(dataTypeValue)){
            case DataSyncerConstants.SITEHEAD:
                tableHeadObj = new SiteDataHeadDo();
                break;
            case DataSyncerConstants.GRIDHEAD:
                tableHeadObj = new GridDataHeadDo();
                break;
            case DataSyncerConstants.FILEHEAD:
                tableHeadObj = new FileDataHeadDo();
                break;
            default:
                break;
        }
        return tableHeadObj;
    }

    public BaseRepository getTableHeadDao(String dataTypeValue) {
        if(StringUtils.isEmpty(dataTypeValue))
            return null;
        BaseRepository tableHeadDao = null;
        switch (Integer.valueOf(dataTypeValue)){
            case DataSyncerConstants.SITEHEAD:
                tableHeadDao = (BaseRepository)applicationContext.getBean("siteDataHeadDao");
                break;
            case DataSyncerConstants.GRIDHEAD:
                tableHeadDao = (BaseRepository)applicationContext.getBean("gridDataHeadDao");
                break;
            case DataSyncerConstants.FILEHEAD:
                tableHeadDao = (BaseRepository)applicationContext.getBean("fileDataHeadDao");
                break;
            default:
                break;
        }
        return tableHeadDao;
    }
}
