package org.teckhooi.store.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.teckhooi.store.dao.DAO;

public abstract class AbstractHibernateDAO<T extends Serializable> extends HibernateDaoSupport implements DAO<T> {

    private Class domainClass;

    protected AbstractHibernateDAO(Class domainClass) {
        this.domainClass = domainClass;
    }

    @Override
    public void insert(T object) {
        getSession().save(object);
    }

    @Override
    public T update(T object) {
        getSession().update(object);
        return object;
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getSession().createCriteria(domainClass).list();
    }

    @Autowired
    public void set(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
