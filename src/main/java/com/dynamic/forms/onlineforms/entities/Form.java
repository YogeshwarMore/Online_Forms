package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@DynamicUpdate
@Table(name = "form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "formid")
    private int formid;
    @Column(name = "formname")
    private String formname;
    @Column(name = "description")
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationdate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date changedate;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "formid")
    private List<Versions> versionsList = new ArrayList<>();

    public List<Versions> getVersionsList() {
        return versionsList;
    }

    public void setVersionsList(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }

    public Form() {
    }

    // Parameterized constructor
    public Form(int formid, String formname, String description, Date creationdate, Date changedate) {
        this.formid = formid;
        this.formname = formname;
        this.description = description;
        this.creationdate = creationdate;
        this.changedate = changedate;
    }

    // Getters and Setters
    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
        this.formid = formid;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String name) {
        this.formname = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

}

