package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "formgroup")
public class FormGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "formgroupid")
    private long formgroupid;
    @Column(name = "name")
    private String name;
    @Column(name = "indexs")
    private int indexs;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "versionid")
    private versions versionid;

    public List<formField> getFormfield() {
        return formfield;
    }

    public void setFormfield(List<formField> formfield) {
        this.formfield = formfield;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "formgroupid")
    private List<formField> formfield =new ArrayList<>();
    public long getFormgroupid() {
        return formgroupid;
    }

    public void setFormgroupid(long formgroupid) {
        this.formgroupid = formgroupid;
    }

    public versions getVersionid() {
        return versionid;
    }

    public void setVersionid(versions versionid) {
        this.versionid = versionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndexs() {
        return indexs;
    }

    public void setIndexs(int indexs) {
        this.indexs = indexs;
    }


}
