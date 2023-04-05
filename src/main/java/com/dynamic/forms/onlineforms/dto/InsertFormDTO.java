package com.dynamic.forms.onlineforms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertFormDTO {


    private String formname;
    private String description;
    private float versionnumber;
    private int indexs;
    private String fieldName;
    private Boolean isoptional;
    private Long toolid;
    private String optionname;
    private List<String> name;



}
