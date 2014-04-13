package com.mizpiz.presist.obj;

import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */
public class StringVal extends Value {
    public StringVal() {
        this.setValue_Type("String");
    }
    // the MountainBike subclass adds one field
    public String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
// the MountainBike subclass has one constructor
@Override
public String toString() {
    return "Value{" +
            "id=" + this.getId() +
            ", name='" + value + '\'' +
            '}';
}
}

