package com.hx.syncer.dao;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yahchen on 2017/11/4.
 */
@Repository
public interface SiteDataHeadDao extends BaseRepository<SiteDataHeadDo,Long>{

}
