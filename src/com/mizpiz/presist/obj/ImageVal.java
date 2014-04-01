package com.mizpiz.presist.obj;

import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */
class ImageVal extends Value {

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

