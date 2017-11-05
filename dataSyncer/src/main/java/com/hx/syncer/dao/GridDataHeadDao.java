package com.hx.syncer.dao;

import com.hx.syncer.bean.GridDataHeadDo;
import com.hx.syncer.bean.SiteDataHeadDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yahchen on 2017/10/29.
 */
@Repository
public interface GridDataHeadDao extends BaseRepository<GridDataHeadDo, Long>{

}
