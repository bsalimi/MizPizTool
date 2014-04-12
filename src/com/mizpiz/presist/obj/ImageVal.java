package com.mizpiz.presist.obj;

import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */
public class ImageVal extends Value {

    public ImageVal() {
        this.setValue_Type("IMAGE");
    }

    public Blob value;
    public Blob getValue() {
        return value;
    }
    public void setValue(Blob value) {
        this.value = value;
    }

}

