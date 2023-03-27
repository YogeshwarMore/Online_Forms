package com.dynamic.forms.onlineforms.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "optionformfields" )
public class optionformfields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionformfieldsid;

    @ManyToOne
    @JoinColumn(name = "formfieldid")
    private formField formField;
    @ManyToOne
    @JoinColumn(name = "optionid")
    private options option;

    public Long getOptionformfieldsid() {
        return optionformfieldsid;
    }

    public void setOptionformfieldsid(Long optionformfieldsid) {
        this.optionformfieldsid = optionformfieldsid;
    }

    public com.dynamic.forms.onlineforms.entities.formField getFormField() {
        return formField;
    }

    public void setFormField(com.dynamic.forms.onlineforms.entities.formField formField) {
        this.formField = formField;
    }

    public options getOption() {
        return option;
    }

    public void setOption(options option) {
        this.option = option;
    }


}
