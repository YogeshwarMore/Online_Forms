package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "filledformfield")
public class filledFormField {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long filledformfieldid;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "filledformid")
    private filledForm filledformid;
    @ManyToOne
    @JoinColumn(name="formfieldid")
    private formField formfieldid;
    private Integer ischecked;
    private String textvalue;
    private Long numericvalue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datetimevalue;
    @ManyToOne
    @JoinColumn(name ="optionid")
    private options optionid;



    public options getOptionid() {
        return optionid;
    }

    public void setOptionid(options optionid) {
        this.optionid = optionid;
    }

    public long getFilledformfieldid() {
        return filledformfieldid;
    }

    public void setFilledformfieldid(long filledformfieldid) {
        this.filledformfieldid = filledformfieldid;
    }

    public filledForm getFilledformid() {
        return filledformid;
    }

    public void setFilledformid(filledForm filledformid) {
        this.filledformid = filledformid;
    }

    public formField getFormfieldid() {
        return formfieldid;
    }

    public void setFormfieldid(formField formfieldid) {
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
