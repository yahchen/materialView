package com.hx.syncer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yahchen on 2017/11/5.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, CrudRepository<T, ID> {
    T getOne(long var1);

    List<T> findAll();

    <S extends T> List<S> save(Iterable<S> iterable);

    <S extends T> S save(S entity);
}
