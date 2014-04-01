

import java.util.Set;

/**
 * Created by The Killer on 16/03/14.
 */

public class Instance {
    private int id;
    private String name;
    private Set properties;
    private Set Value;
    private Entity entity;

    public Instance() {
    }

    public Instance(int id, String name, Set properties, Set value, Entity entity) {
        this.id = id;
        this.name = name;
        this.properties = properties;
        Value = value;
        this.entity = entity;
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

    public Set getProperties() {
        return properties;
    }

    public void setProperties(Set properties) {
        this.properties = properties;
    }

    public Set getValue() {
        return Value;
    }

    public void setValue(Set value) {
        Value = value;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * Created by The Killer on 16/03/14.
     */


    public static class Entity {
        private int id;
        private String name;
        private int salary;
        private Set properties;
        public Entity() {}
        public Entity(String name, Set properties) {
            this.name = name;
            this.properties =properties ;

        }
        public int getId() {
            return id;
        }
        public void setId( int id ) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName( String name ) {
            this.name = name;
        }
        public Set getProperties() {
            return properties;
        }
        public void setProperties(Set properties) {
            this.properties = properties;
        }
    }
}