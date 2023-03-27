package com.dynamic.forms.onlineforms.entities;

import jakarta.persistence.*;

@Entity
public class options {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long optionid;
    private String name;
//    @ManyToMany
//    private List<formField> formfieldid;

//    public List<formField> getFormfieldid() {
//        return formfieldid;
//    }
//
//    public void setFormfieldid(List<formField> formfieldid) {
//        this.formfieldid = formfieldid;
//    }

    public long getOptionid() {
        return optionid;
    }

    public void setOptionid(long optionid) {
        this.optionid = optionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
