package com.mizpiz.presist.obj;

import java.util.Set;

/**
 * Created by The Killer on 16/03/14.
 */

public class Instance {
    private int id;
    private String name;
    private Set<Property> properties;
    private Set<Value> Value;
    private com.mizpiz.presist.obj.Entity entity;

    public Instance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getValue() {
        return Value;
    }

    public void setValue(Set value) {
        Value = value;
    }

    public com.mizpiz.presist.obj.Entity getEntity() {
        return entity;
    }


    public void setEntity(com.mizpiz.presist.obj.Entity entity) {
        this.entity = entity;

    }

    @Override
    public String toString() {
        return "Instance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}