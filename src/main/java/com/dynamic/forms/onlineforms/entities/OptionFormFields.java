package com.dynamic.forms.onlineforms.entities;


import javax.persistence.*;
@Entity
@Table(name = "optionformfields")
public class OptionFormFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optionformfieldsid")
    private long optionformfieldsid;

    @ManyToOne
    @JoinColumn(name = "formfieldid")
    private FormField formField;
    @ManyToOne
    @JoinColumn(name = "optionid")
    private Options option;

    public long getOptionformfieldsid() {
        return optionformfieldsid;
    }

    public void setOptionformfieldsid(long optionformfieldsid) {
        this.optionformfieldsid = optionformfieldsid;
    }

    public FormField getFormField() {
        return formField;
    }

    public void setFormField(FormField formField) {
        this.formField = formField;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }


}
