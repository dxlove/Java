package com.wyt.learn.domain.vo;

import com.wyt.learn.domain.model.entity.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 *         Created by Darcy on 2017/7/18.
 */
public class RestaurantVO {

    private List<Table> tables = new ArrayList<>();
    private String name;
    private String id;
    private String address;

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Constructor
     */
    public RestaurantVO() {
    }

    /**
     *
     * @param tables
     */
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    /**
     *
     * @return
     */
    public List<Table> getTables() {
        return tables;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return "{id: " + id + ", name: " +
                name + ", address: " + address +
                ", tables: " + tables + "}";
    }
}
