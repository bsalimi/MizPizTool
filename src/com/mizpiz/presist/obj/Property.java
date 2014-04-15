package com.mizpiz.presist.obj;

import javax.persistence.*;
import java.lang.String; /**
 * Created by The Killer on 16/03/14.
 */

@Entity
@Table(name = "PROPERTY")
public class Property {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PROPERTY_ID")
    private Long id;
    @Column(name="PROPERTY_NAME")
    private String name;
    @Column(name="PROPERTY_TYPE")
    private String type ;

    public Property() {
    }

    public Property(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
