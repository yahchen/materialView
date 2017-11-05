package com.hx.syncer.dao;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */
public interface SiteDataHeadDao extends CustomRepository<SiteDataHeadDo,Long> {

    SiteDataHeadDo getOne(long var1);

    List<SiteDataHeadDo> findAll();

    <S extends SiteDataHeadDo> List<S> save(Iterable<S> iterable);

    <S extends SiteDataHeadDo> S save(S entity);
}
