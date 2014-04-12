package com.mizpiz.presist.obj;

import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */
public class IntegerVal extends Value {

    public IntegerVal() {
        this.setValue_Type("LONG");
    }

    // the MountainBike subclass adds one field
    public long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
    // the MountainBike subclass has one c   onstructor
}

