package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.FilledForm;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Long filledformfieldid;

    private Long filledformid;

    private Long formfieldid;
    private Integer ischecked;
    private String textvalue;
    private Long numericvalue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datetimevalue;

    private Long optionid;


}
