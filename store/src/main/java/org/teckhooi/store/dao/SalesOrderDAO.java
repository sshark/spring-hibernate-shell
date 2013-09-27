package org.teckhooi.store.dao;

import java.util.Date;
import java.util.List;

import org.teckhooi.store.domain.LineItem;
import org.teckhooi.store.domain.SalesOrder;

/**
 *
 * @author Lim, Teck Hooi
 *
 *
 */

public interface SalesOrderDAO extends DAO<SalesOrder>{
    List<SalesOrder> findLineItemsAtLeast(double price);
    List<SalesOrder> findSalesOrdersSince(Date salesDate);
    List<LineItem> findLineItemsSince(Date salesDate);
}
