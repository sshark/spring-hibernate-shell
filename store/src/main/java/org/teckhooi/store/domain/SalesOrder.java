package org.teckhooi.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 *
 * @author Lim, Teck Hooi
 *
 *
 */

@Entity
@Table
public class SalesOrder implements Serializable {
    @Id
    @GeneratedValue
    private Long oid;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LineItem> items = new ArrayList<>();

    private String name;
    private Date dateCreated;

    public SalesOrder(String name, List<LineItem> items) {
        this(name, items, new Date());
    }

    public SalesOrder(String name, List<LineItem> items, Date dateCreated) {
        this.items = items;
        this.name = name;
        this.dateCreated = dateCreated;
    }
    public SalesOrder() {}

    public void add(LineItem item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
