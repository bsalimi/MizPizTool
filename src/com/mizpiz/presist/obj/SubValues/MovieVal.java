package com.mizpiz.presist.obj.SubValues;

/**
 * Created by babak on 2014-04-03.
 */

import com.mizpiz.presist.obj.Value;

import javax.persistence.*;

import java.sql.Blob;
@Entity
@Table(name="Value")
@DiscriminatorValue("M")
public class MovieVal extends Value {

    // the MountainBike subclass adds one field
    @Lob
    public Blob value;
    public Blob getValue() {
        return value;
    }

    public void setValue(Blob value) {
        this.value = value;
    }
// the MountainBike subclass has one constructor

}

