package com.mizpiz.presist.obj;

/**
 * Created by babak on 2014-04-03.
 */

import java.sql.Blob;

public class MovieVal extends Value {
    public MovieVal() {
        this.setValue_Type("String");
    }
    // the MountainBike subclass adds one field
    public Blob value;
    public Blob getValue() {
        return value;
    }

    public void setValue(Blob value) {
        this.value = value;
    }
// the MountainBike subclass has one constructor

}

