package com.mizpiz.presist.obj.SubValues;

import com.mizpiz.presist.obj.Value;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */
@Entity
@Table(name="Value")
@DiscriminatorValue("I")
public class IntegerVal extends Value {



    // the MountainBike subclass adds one field
    @Column(name="IntegerVal")
    public long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
    // the MountainBike subclass has one c   onstructor
}

