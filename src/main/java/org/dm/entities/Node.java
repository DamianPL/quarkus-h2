package org.dm.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
public class Node extends PanacheEntity {
    public String name;
    public String type;

    @ElementCollection
    public Set<String> labels;

    @ElementCollection
    @CollectionTable(name = "node_properties",
            joinColumns = {@JoinColumn(name = "property_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "property_name")
    @Column(name = "properties")
    public Map<String, String> properties;

    public String getType() {
        return type.toUpperCase();
    }

    public void setType(String type) {
        this.type = type.toUpperCase();
    }
}
