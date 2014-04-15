package com.mizpiz.presist.obj;

import java.sql.Blob;
import javax.persistence.*;
/**
 * Created by The Killer on 16/03/14.
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue("V")
public class Value {
    @Id
    @GeneratedValue
    @Column(name = "VALUE_ID")
    private Long id;
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name="VALUE_PROPERTY",
            joinColumns = @JoinColumn(name="VALUE_ID"),
            inverseJoinColumns = @JoinColumn(name="PROPERTY_ID")
    )
    private Property property;
    public Property getProperty() {
        return property;
    }
    public void setProperty(Property property) {
        this.property = property;
    }
    public Value() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}

