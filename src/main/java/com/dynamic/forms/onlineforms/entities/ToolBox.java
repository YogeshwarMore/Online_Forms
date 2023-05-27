package com.dynamic.forms.onlineforms.entities;

import javax.persistence.*;
@Entity
@Table(name = "toolbox")
public class ToolBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toolid", nullable = false)
    private long toolid;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    public long getId() {
        return toolid;
    }

    public void setId(long id) {
        this.toolid = id;
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

}