package com.hx.syncer.service;

import com.hx.syncer.bean.SiteDataHeadDo;
import com.hx.syncer.dao.SiteDataHeadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */
@Service
public class SiteDataHeadService implements DaoServiceImpl<SiteDataHeadDo> {
    @Autowired
    private SiteDataHeadDao siteDataHeadDao;

    @Override
    public Iterable<SiteDataHeadDo> save(Iterable<SiteDataHeadDo> entities) {
        if (null != entities && entities.iterator().hasNext()) {
            return siteDataHeadDao.save(entities);
        }
        return null;
    }

    @Override
    public SiteDataHeadDo saveOne(SiteDataHeadDo entity) {
        if (null != entity) {
            return siteDataHeadDao.save(entity);
        }
        return null;
    }

    @Override
    public List<SiteDataHeadDo> findAll() {
        return siteDataHeadDao.findAll();
    }
}
