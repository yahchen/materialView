package com.hx.syncer.service;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.dao.GridDataHeadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahchen on 2017/10/29.
 */
@Service
public class GridDataHeadService implements DaoServiceImpl<GridDataHeadDo>{
    @Autowired
    private GridDataHeadDao GridDataHeadDao;
    @Override
    public Iterable<GridDataHeadDo> save(Iterable<GridDataHeadDo> entities) {
        if(null != entities && entities.iterator().hasNext()){
            return GridDataHeadDao.save(entities);
        }
        return null;
    }

    @Override
    public GridDataHeadDo saveOne(GridDataHeadDo entity) {
        if(null != entity){
            return GridDataHeadDao.save(entity);
        }
        return null;
    }

    @Override
    public List<GridDataHeadDo> findAll() {
        return GridDataHeadDao.findAll();
    }
}
