package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.Form;
import com.dynamic.forms.onlineforms.entities.filledForm;
import com.dynamic.forms.onlineforms.entities.filledFormField;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.List;

public class FilledFormDTO {
    private String formname;
    private String Description;

    private List<filledForm> filledFormList;

    public FilledFormDTO(String formname, String description, List<filledForm> filledFormList) {
        this.formname = formname;
        Description = description;
        this.filledFormList = filledFormList;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<filledForm> getFilledFormList() {
        return filledFormList;
    }

    public void setFilledFormList(List<filledForm> filledFormList) {
        this.filledFormList = filledFormList;
    }
}
