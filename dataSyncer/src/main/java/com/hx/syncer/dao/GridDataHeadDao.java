package com.hx.syncer.dao;

import com.hx.syncer.bean.GridDataHeadDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahchen on 2017/10/29.
 */
public interface GridDataHeadDao extends CustomRepository<GridDataHeadDo,Long> {
}
