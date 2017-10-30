package com.hx.syncer.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahchen on 2017/10/29.
 */
@Service
public interface DaoServiceImpl<T extends Object> {
    boolean save(Iterable<T> entities);

    boolean saveOne(T one);

    List<T> findAll();
}
