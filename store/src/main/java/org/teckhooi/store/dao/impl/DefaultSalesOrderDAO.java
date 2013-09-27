package org.teckhooi.store.dao.impl;

import java.util.Date;
import java.util.List;

import static org.hibernate.criterion.Restrictions.*;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.teckhooi.store.dao.SalesOrderDAO;
import org.teckhooi.store.domain.LineItem;
import org.teckhooi.store.domain.SalesOrder;

/**
 *
 * @author Lim, Teck Hooi
 *
 *
 */

@Component
@Transactional
public class DefaultSalesOrderDAO extends AbstractHibernateDAO<SalesOrder> implements SalesOrderDAO {
    public DefaultSalesOrderDAO() {
        super(SalesOrder.class);
    }

    @Override
    public List<SalesOrder> findLineItemsAtLeast(double price) {
        return (List<SalesOrder>) getSession().createCriteria(SalesOrder.class)
            .add(ge("items.price", price))
            .list();
    }

    @Override
    public List<SalesOrder> findSalesOrdersSince(Date salesDate) {
        Query query = getSession().createQuery("select distinct s from SalesOrder s inner join s.items i where i.dateCreated >= :salesDate");
        query.setDate("salesDate", salesDate);
        return query.list();
    }

    @Override
    public List<LineItem> findLineItemsSince(Date salesDate) {
        Query query = getSession().createQuery("select i from SalesOrder s inner join s.items i where i.dateCreated >= :salesDate");
        query.setDate("salesDate", salesDate);
        return query.list();
    }
}
