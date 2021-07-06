package com.yadas.web.rest.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table("shopping_cart")
public class ShoppingCart {
    @PrimaryKey
    private String userid;
    private int item_count;
    private Timestamp last_update_timestamp;

    public ShoppingCart() {
    }

    public ShoppingCart(String userid, int item_count, Timestamp last_update_timestamp) {
        this.userid = userid;
        this.item_count = item_count;
        this.last_update_timestamp = last_update_timestamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public Timestamp getLast_update_timestamp() {
        return last_update_timestamp;
    }

    public void setLast_update_timestamp(Timestamp last_update_timestamp) {
        this.last_update_timestamp = last_update_timestamp;
    }
}
