package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@DynamicUpdate
@Table(name = "form")
public class Form {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formid")
    private long formid;
    @Column(name = "formname")
    private String formname;

    @Column(name = "description")
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationdate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date changedate;
    @Column(name = "flag")
    private int flag;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "formid")
    private List<Versions> versionsList = new ArrayList<>();

    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public List<Versions> getVersionsList() {
        return versionsList;
    }

    public void setVersionsList(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }

    public Form() {
    }


    // Getters and Setters
    public long getFormid() {
        return formid;
    }

    public void setFormid(long formid) {
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
    public Form(long formid, String formname, String description, Date creationdate, Date changedate, int flag, List<Versions> versionsList) {
        this.formid = formid;
        this.formname = formname;
        this.description = description;
        this.creationdate = creationdate;
        this.changedate = changedate;
        this.flag = flag;
        this.versionsList = versionsList;
    }

}

