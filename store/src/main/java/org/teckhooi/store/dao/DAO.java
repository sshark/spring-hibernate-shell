package org.teckhooi.store.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lim, Teck Hooi
 *
 *
 */

public interface DAO<T> {
    void insert(T domain);
    T update(T domain);
    List<T> findAll();
}
