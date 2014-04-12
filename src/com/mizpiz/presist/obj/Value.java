package com.mizpiz.presist.obj;

import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */

public class Value {
    private int id;
    private String Value_TYPE;
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Value() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setValue_Type(String value_Type) {
        Value_TYPE = value_Type;
    }
    public String getValue_Type() {
        return Value_TYPE;
    }
}

