package com.hx.syncer.util;

import com.hx.syncer.bean.FileDataHeadDo;
import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.bean.SatelliteFileDataHeadDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.BaseRepository;
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

    public BaseRepository getSiteEleDaoObj(String logo) {
        if (StringUtils.isEmpty(logo))
            return null;
        String className = DataSyncerConstants.SITE_DATA_DAO_NAMES.get(logo);
        return (BaseRepository) applicationContext.getBean(className);
    }

    public Object getSiteEleDoObj(String logo) throws Exception {
        if (StringUtils.isEmpty(logo))
            return null;
        String className = "com.hx.syncer.bean." + DataSyncerConstants.SITE_DATA_DO_NAMES.get(logo);
        return null == className ? null : Class.forName(className).newInstance();
    }

    public BaseRepository getTableEleDaoObj(String logo) {
        if (StringUtils.isEmpty(logo))
            return null;
        String[] sameFactors = logo.split("_");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        int maxSimilarityValue = 0;
        String className = null;
        for (String name : beanNames) {
            int curSimilarityValue = 0;
            if (name.endsWith("Dao") && name.startsWith((logo.charAt(0) + "").toLowerCase())) {
                char[] lowLogo = logo.toLowerCase().toCharArray();
                String lowBeanName = name.replaceFirst("Dao", "").toLowerCase();
                for (char factor : lowLogo) {
                    if (lowBeanName.contains(factor + "")) {
                        lowBeanName = lowBeanName.replaceFirst(factor + "", "");
                        curSimilarityValue++;
                    }
                }
                if (maxSimilarityValue < curSimilarityValue) {
                    maxSimilarityValue = curSimilarityValue;
                    className = name;
                }
            }
        }
        return null == className ? null : (BaseRepository) applicationContext.getBean(className);
    }

    public Object getTableEleBeanClassName(String logo) throws Exception {
        if (StringUtils.isEmpty(logo))
            return logo;
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        int maxSimilarityValue = 0;
        String className = null;
        for (String name : beanNames) {
            int curSimilarityValue = 0;
            if (name.endsWith("Dao") && name.startsWith((logo.charAt(0) + "").toLowerCase())) {
                char[] lowLogo = logo.toLowerCase().toCharArray();
                String lowBeanName = name.replaceFirst("Dao", "").toLowerCase();
                for (char factor : lowLogo) {
                    if (lowBeanName.contains(factor + "")) {
                        lowBeanName = lowBeanName.replaceFirst(factor + "", "");
                        curSimilarityValue++;
                    }
                }
                if (maxSimilarityValue < curSimilarityValue) {
                    maxSimilarityValue = curSimilarityValue;
                    className = name.replace("Dao", "Do");
                }
            }
        }
        className = "com.hx.syncer.bean." + className.substring(0, 1).toUpperCase() + className.substring(1);
        return null == className ? null : Class.forName(className).newInstance();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object getTableHeadObj(String dataTypeValue) {
        if (StringUtils.isEmpty(dataTypeValue))
            return null;
        Object tableHeadObj = null;
        switch (Integer.valueOf(dataTypeValue)) {
            case DataSyncerConstants.SITEHEAD:
                tableHeadObj = new SiteDataHeadDo();
                break;
            case DataSyncerConstants.GRIDHEAD:
                tableHeadObj = new GridDataHeadDo();
                break;
            case DataSyncerConstants.FILEHEAD:
                tableHeadObj = new FileDataHeadDo();
                break;
            case DataSyncerConstants.SATEFILEHEAD:
                tableHeadObj = new SatelliteFileDataHeadDo();
                break;
            default:
                break;
        }
        return tableHeadObj;
    }

    public BaseRepository getTableHeadDao(String dataTypeValue) {
        if (StringUtils.isEmpty(dataTypeValue))
            return null;
        BaseRepository tableHeadDao = null;
        switch (Integer.valueOf(dataTypeValue)) {
            case DataSyncerConstants.SITEHEAD:
                tableHeadDao = (BaseRepository) applicationContext.getBean("siteDataHeadDao");
                break;
            case DataSyncerConstants.GRIDHEAD:
                tableHeadDao = (BaseRepository) applicationContext.getBean("gridDataHeadDao");
                break;
            case DataSyncerConstants.FILEHEAD:
                tableHeadDao = (BaseRepository) applicationContext.getBean("fileDataHeadDao");
                break;
            case DataSyncerConstants.SATEFILEHEAD:
                tableHeadDao = (BaseRepository) applicationContext.getBean("satelliteFileDataHeadDao");
                break;
            default:
                break;
        }
        return tableHeadDao;
    }

    public String getOutIdName(String dataType) {
        if (StringUtils.isEmpty(dataType))
            return null;
        String outIdName = null;
        switch (Integer.valueOf(dataType)) {
            case DataSyncerConstants.SITEHEAD:
                outIdName = "s_d_id";
                break;
            case DataSyncerConstants.GRIDHEAD:
                outIdName = "";
                break;
            case DataSyncerConstants.FILEHEAD:
                outIdName = "";
                break;
            case DataSyncerConstants.SATEFILEHEAD:
                outIdName = "s_f_id";
                break;
            default:
                break;
        }
        return outIdName;
    }

}
