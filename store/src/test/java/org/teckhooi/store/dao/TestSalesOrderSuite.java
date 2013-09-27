package org.teckhooi.store.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.teckhooi.store.domain.LineItem;
import org.teckhooi.store.domain.SalesOrder;

/**
 *
 * @author Lim, Teck Hooi
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TestSalesOrderSuite {

    static private final Logger LOGGER = LoggerFactory.getLogger(TestSalesOrderSuite.class);

    @Autowired
    private SalesOrderDAO salesOrderDAO;

    @Before
    public void createNewSalesOrders() {

        Date alphaOrderDate = new DateTime(2005, 3, 26, 12, 0, 0, 0).toDate();
        Date betaOrderDate = new DateTime(2005, 4, 2, 12, 0, 0, 0).toDate();
        Date moreAlphaOrderDate = new DateTime(2005, 4, 21, 12, 0, 0, 0).toDate();

        List<LineItem> alphaLineItems = new ArrayList<>();

        alphaLineItems.add(new LineItem("cpu", "i4470K", 100, alphaOrderDate));
        alphaLineItems.add(new LineItem("storage", "WD 2TB", 50, alphaOrderDate));
        alphaLineItems.add(new LineItem("gpu", "Nvidia GTX770", 200, alphaOrderDate));

        salesOrderDAO.insert(new SalesOrder("Alpha Order", alphaLineItems, alphaOrderDate));

        List<LineItem> betaLineItems = new ArrayList<>();

        betaLineItems.add(new LineItem("cpu", "A8", 50, betaOrderDate));
        betaLineItems.add(new LineItem("gpu", "ATi HD7980", 100, betaOrderDate));

        salesOrderDAO.insert(new SalesOrder("Beta Order", betaLineItems, betaOrderDate));

        List<LineItem> moreAlphaLineItems = new ArrayList<>();

        moreAlphaLineItems.add(new LineItem("storage", "Intel SSD", 250, moreAlphaOrderDate));
        moreAlphaLineItems.add(new LineItem("gpu", "ATi HD7980", 100, moreAlphaOrderDate));

        salesOrderDAO.insert(new SalesOrder("More Alpha Order", moreAlphaLineItems, moreAlphaOrderDate));
    }

    @Test
    public void findSalesOrdersWithLineItemsForADate() {
        List<SalesOrder> salesOrders = salesOrderDAO.findSalesOrdersSince(new DateTime(2005, 4, 2, 12, 0, 0, 0).toDate());
        Assert.assertEquals(2, salesOrders.size());
        for (SalesOrder order : salesOrders) {
            LOGGER.debug(order.getName() + " - " + order.getDateCreated());
        }
    }

    @Test
    public void findLineItemsForADate() {
        List<LineItem> lineItems = salesOrderDAO.findLineItemsSince(new DateTime(2005, 4, 2, 12, 0, 0, 0).toDate());
        Assert.assertEquals(4, lineItems.size());
        for (LineItem l : lineItems) {
            LOGGER.debug(l.getName() + " - " + l.getDescription());
        }
    }
}
