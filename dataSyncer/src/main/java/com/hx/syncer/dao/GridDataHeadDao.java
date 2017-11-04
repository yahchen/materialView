package com.hx.syncer.dao;

import com.hx.syncer.bean.GridDataHeadDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahchen on 2017/10/29.
 */
@Repository
public interface GridDataHeadDao extends JpaRepository<GridDataHeadDo,Long> {

    GridDataHeadDo getOne(long var1);

    List<GridDataHeadDo> findAll();

    @Override
    <S extends GridDataHeadDo> List<S> save(Iterable<S> iterable);

    <S extends GridDataHeadDo> S save(S entity);

    void deleteInBatch(Iterable<GridDataHeadDo> iterable);
}
