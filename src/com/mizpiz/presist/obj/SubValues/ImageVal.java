package com.mizpiz.presist.obj.SubValues;

import com.mizpiz.presist.obj.Value;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by The Killer on 16/03/14.
 */
@Entity
@Table(name="Value")
@DiscriminatorValue("IMG")
public class ImageVal extends Value {
    @Lob
    public Blob value;
    public Blob getValue() {
        return value;
    }
    public void setValue(Blob value) {
        this.value = value;
    }

}

