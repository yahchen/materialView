package com.hx.syncer.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * 自定义repository的方法接口实现类,该类主要提供自定义的公用方法
 *
 * @author xiaowen
 * @date 2016年5月30日 @ version 1.0
 * @param <T>
 * @param <ID>
 */
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, Serializable>
        implements CustomRepository<T, Serializable> {

    @SuppressWarnings("unused")
    private Logger logger = Logger.getLogger(CustomRepositoryImpl.class);
    /**
     * 持久化上下文
     */
    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Override
    public void store(Object... item) {
        entityManager.persist(item);
        entityManager.flush();
    }

    @Override
    public void update(Object... item) {
        if (null != item) {
            for (Object entity : item) {
                entityManager.merge(entity);
            }
        }
    }

    @Override
    public int executeUpdate(String qlString, Object... values) {
        Query query = entityManager.createQuery(qlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        return query.executeUpdate();
    }

    @Override
    public int executeUpdate(String qlString, Map<String, Object> params) {
        Query query = entityManager.createQuery(qlString);
        for (String name : params.keySet()) {
            query.setParameter(name, params.get(name));
        }
        return query.executeUpdate();
    }

    @Override
    public int executeUpdate(String qlString, List<Object> values) {
        Query query = entityManager.createQuery(qlString);
        for (int i = 0; i < values.size(); i++) {
            query.setParameter(i + 1, values.get(i));
        }
        return query.executeUpdate();
    }
}
