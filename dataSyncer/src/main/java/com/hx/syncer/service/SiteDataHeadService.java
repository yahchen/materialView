package com.hx.syncer.service;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.GridDataHeadDao;
import com.hx.syncer.dao.SiteDataHeadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class SiteDataHeadService implements DaoServiceImpl<SiteDataHeadDo>{
    @Autowired
    private SiteDataHeadDao siteDataHeadDao;
    @Override
    public boolean save(Iterable<SiteDataHeadDo> entities) {
        if(null != entities && entities.iterator().hasNext()){
            siteDataHeadDao.save(entities);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveOne(SiteDataHeadDo entity) {
        if(null != entity){
            siteDataHeadDao.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<SiteDataHeadDo> findAll() {
        return siteDataHeadDao.findAll();
    }
}
