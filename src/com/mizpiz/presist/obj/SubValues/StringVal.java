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
@DiscriminatorValue("S")
public class StringVal extends Value {
    // the MountainBike subclass adds one field
    @Column(name="StringVal")
    private String value;
    public  String getValue() {
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
            ", name='" + value + '\''+  " Valuetype: "+" ,property : "+ getProperty()+
            '}';
}
}

