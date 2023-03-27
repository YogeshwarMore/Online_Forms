package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "filledform")
public class filledForm {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "filledformid")
        private long filledformid;
        @ManyToOne
        @JsonIgnore
        @JoinColumn(name = "formid")
        private Form formid;
    @Column(name = "userid")
    private int userid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "filldate")
    private Date filldate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filledformid")
    private List<filledFormField> filledFormFieldList =new ArrayList<>();

    public List<filledFormField> getFilledFormFieldList() {
        return filledFormFieldList;
    }

    public void setFilledFormFieldList(List<filledFormField> filledFormFieldList) {
        this.filledFormFieldList = filledFormFieldList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public long getFilledformid() {
        return filledformid;
    }

    public void setFilledformid(long filledformid) {
        this.filledformid = filledformid;
    }


    public Form getFormid() {
        return formid;
    }

    public void setFormid(Form formid) {
        this.formid = formid;
    }


    public Date getFilldate() {
        return filldate;
    }

    public void setFilldate(Date filldate) {
        this.filldate = filldate;
    }


}
