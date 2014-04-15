package com.mizpiz.presist.obj;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ENTITY",
uniqueConstraints = {@UniqueConstraint(columnNames = {"ENTITY_NAME"})})
public class Myentity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ENTITY_ID")
    public Long id;
    @Column(name="ENTITY_NAME",nullable = false)
    public String name;
    @OneToMany
    @JoinTable(
            name="ENTITY_PROPERTY",
            joinColumns = @JoinColumn( name="ENTITY_ID"),
            inverseJoinColumns = @JoinColumn( name="PROPERTY_ID")
    )
    public Set<Property> properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        String pr = null;
        for (Property property : properties) {
            pr = pr + " , " + property.toString();
        }
        return "Entity{" +
                "id=" + id +
                ", name='" + name + "Propeties:" + pr
                + '}';
    }
}
