package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "formgroup")
public class FormGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formgroupid")
    private long formgroupid;
    @Column(name = "name")
    private String name;
    @Column(name = "indexs")
    private int indexs;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "versionid")
    private Versions versionid;

    public List<FormField> getFormfield() {
        return formfield;
    }

    public void setFormfield(List<FormField> formfield) {
        this.formfield = formfield;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "formgroupid")
    private List<FormField> formfield = new ArrayList<>();

    public long getFormgroupid() {
        return formgroupid;
    }

    public void setFormgroupid(long formgroupid) {
        this.formgroupid = formgroupid;
    }

    public Versions getVersionid() {
        return versionid;
    }

    public void setVersionid(Versions versionid) {
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
