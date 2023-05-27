package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.FilledForm;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilledFormFieldDTO {
    @JsonIgnore
    private long filledformfieldid;
    @JsonIgnore
    private long filledformid;

    private long formfieldid;
    private Integer ischecked;
    private String textvalue;
    private long numericvalue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datetimevalue;

    private long optionid;


}
