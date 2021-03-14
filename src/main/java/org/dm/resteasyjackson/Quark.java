package org.dm.resteasyjackson;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Quark extends PanacheEntity {
    public String name;
    public String description;
}