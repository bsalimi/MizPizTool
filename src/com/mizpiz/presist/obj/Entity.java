package com.mizpiz.presist.obj;

import java.util.Set;

public class Entity {
    public int id;
    public String name;
    public Set<Property> properties;

    public Entity() {
    }

    public Entity(int id, String name, Set<Property> properties) {
        this.id = id;
        this.name = name;
        this.properties = properties;
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

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                     '}';
    }
}
