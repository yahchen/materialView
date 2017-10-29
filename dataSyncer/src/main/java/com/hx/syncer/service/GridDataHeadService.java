package com.hx.syncer.service;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.dao.GridDataHeadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yahchen on 2017/10/29.
 */
@Service
public class GridDataHeadService implements DaoServiceImpl<GridDataHeadDo>{
    @Autowired
    private GridDataHeadDao gridDataHeadDao;
    @Override
    public boolean save(Iterable<GridDataHeadDo> entities) {
        if(null != entities && entities.iterator().hasNext()){
            gridDataHeadDao.save(entities);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveOne(GridDataHeadDo entity) {
        if(null != entity){
            gridDataHeadDao.save(entity);
            return true;
        }
        return false;
    }
}
