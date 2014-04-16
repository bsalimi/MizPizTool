package com.mizpiz.presist.obj;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by The Killer on 16/03/14.
 */
@Entity
@Table(name = "INSTANCE")
public class Instance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="INSTANCE_ID")
    private int id;
    @Column(name="INSTANCE_NAME")
    private String name;
    @OneToMany
    @JoinTable(
            name="INSTANCE_VALUE",
            joinColumns = @JoinColumn( name="INSTANCE_ID"),
            inverseJoinColumns = @JoinColumn( name="VALUE_ID")
    )
    private Set<Value> values;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name="INSTANCEt_ENTITY",
            joinColumns = @JoinColumn(name="INSTANCE_ID"),
            inverseJoinColumns = @JoinColumn(name="ENTITY_ID")
    )
    private Myentity entity;

    public Instance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getValues() {
        return values;
    }

    public void setValues(Set values) {
        this.values = values;
    }

    public com.mizpiz.presist.obj.Myentity getEntity() {
        return entity;
    }

    public void setEntity(com.mizpiz.presist.obj.Myentity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        String pr="empty";
        String val="empty";

        return "Instance{" +
                "id=" + id +
                ", name='" + name +"Entitiy: "+entity.toString()+'\''  + "values:"+ getValues().toString() +'\'' +
                '}';
    }
}