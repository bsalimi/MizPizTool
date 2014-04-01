package com.mizpiz.presist.obj;

import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */

public class Value {
    private int id;
    public Value() {}

    public Value(int id) {
                this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

