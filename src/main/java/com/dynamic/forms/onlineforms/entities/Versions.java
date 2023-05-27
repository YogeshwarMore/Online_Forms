package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "versions")
public class Versions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "versionid")
    private long versionid;
    @Column(name = "versionnumber")
    private float versionnumber;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "formid", referencedColumnName = "formid")
    private Form formid;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "versionid")
    private List<FormGroup> formgroup = new ArrayList<>();


    public List<FilledForm> getFilledFormList() {
        return filledFormList;
    }

    public void setFilledFormList(List<FilledForm> filledFormList) {
        this.filledFormList = filledFormList;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "versionid")
    private List<FilledForm> filledFormList = new ArrayList<>();

    public List<FormGroup> getFormgroup() {
        return formgroup;
    }

    public void setFormgroup(List<FormGroup> formgroup) {
        this.formgroup = formgroup;
    }

    public Versions() {
    }

    public long getVersionid() {
        return versionid;
    }

    public Versions(long versionid, float versionnumber, Form formid) {
        this.versionid = versionid;
        this.versionnumber = versionnumber;
        this.formid = formid;
    }

    public void setVersionid(long versionid) {
        this.versionid = versionid;
    }

    public float getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(float versionnumber) {
        this.versionnumber = versionnumber;
    }

    public Form getFormid() {
        return formid;
    }

    public void setFormid(Form formid) {
        this.formid = formid;
    }
}
