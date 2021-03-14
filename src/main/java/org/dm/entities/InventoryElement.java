package org.dm.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class InventoryElement extends PanacheEntity {
    public String name;
    public String type;
    public String identifier;
    public int level;

    @ManyToOne()
    public InventoryElement parent;

    @ElementCollection
    @CollectionTable(name = "inventory_element_properties",
            joinColumns = {@JoinColumn(name = "property_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "property_name")
    @Column(name = "properties")
    public Map<String, String> properties;

    @OneToMany(mappedBy = "parent")
    public List<InventoryElement> children;
}
