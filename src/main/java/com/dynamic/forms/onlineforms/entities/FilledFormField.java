package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "filledformfield")
public class FilledFormField {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long filledformfieldid;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "filledformid")
    private FilledForm filledformid;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "formfieldid")
    private FormField formfieldid;
    private Integer ischecked;
    private String textvalue;
    private Long numericvalue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datetimevalue;
    @ManyToOne
    @JoinColumn(name = "optionid")
    private Options optionid;


    public Options getOptionid() {
        return optionid;
    }

    public void setOptionid(Options optionid) {
        this.optionid = optionid;
    }

    public long getFilledformfieldid() {
        return filledformfieldid;
    }

    public void setFilledformfieldid(long filledformfieldid) {
        this.filledformfieldid = filledformfieldid;
    }

    public FilledForm getFilledformid() {
        return filledformid;
    }

    public void setFilledformid(FilledForm filledformid) {
        this.filledformid = filledformid;
    }

    public FormField getFormfieldid() {
        return formfieldid;
    }

    public void setFormfieldid(FormField formfieldid) {
        this.formfieldid = formfieldid;
    }

    public Integer getIschecked() {
        return ischecked;
    }

    public void setIschecked(Integer ischecked) {
        this.ischecked = ischecked;
    }

    public String getTextvalue() {
        return textvalue;
    }

    public void setTextvalue(String textvalue) {
        this.textvalue = textvalue;
    }

    public Long getNumericvalue() {
        return numericvalue;
    }

    public void setNumericvalue(Long numericvalue) {
        this.numericvalue = numericvalue;
    }

    public Date getDatetimevalue() {
        return datetimevalue;
    }

    public void setDatetimevalue(Date datetimevalue) {
        this.datetimevalue = datetimevalue;
    }


}
