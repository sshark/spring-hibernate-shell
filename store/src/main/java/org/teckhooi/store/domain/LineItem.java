package org.teckhooi.store.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lim, Teck Hooi
 *
 *
 */

@Entity
@Table
public class LineItem implements Serializable {
    @Id
    @GeneratedValue
    private Long oid;

    private String name;
    private String description;
    private double price;
    private Date dateCreated;

    public LineItem(String name, String description, double price) {
        this(name, description, price, new Date());
    }

    public LineItem(String name, String description, double price, Date dateCreated) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateCreated = dateCreated;
    }

    public LineItem() {}

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
