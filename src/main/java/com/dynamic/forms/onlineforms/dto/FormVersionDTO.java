package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.versions;

import java.util.List;

public class FormVersionDTO {
    private String formname;
    private List<Float> versionnumber;

    public FormVersionDTO(String formname, List<Float> versionnumber) {
        this.formname = formname;
        this.versionnumber = versionnumber;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public List<Float> getVersionnumber() {
        return versionnumber;
    }

    public void setVersionnumber(List<Float> versionnumber) {
        this.versionnumber = versionnumber;
    }



}
