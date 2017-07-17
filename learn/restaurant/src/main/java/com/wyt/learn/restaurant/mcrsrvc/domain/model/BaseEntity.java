package com.wyt.learn.restaurant.mcrsrvc.domain.model;

/**
 * 抽象实体的继承类
 *
 * @author Darcy
 *         Created by Darcy on 2017/7/17.
 */
public abstract class BaseEntity<T> extends Entity<T> {
    private T id;

    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
