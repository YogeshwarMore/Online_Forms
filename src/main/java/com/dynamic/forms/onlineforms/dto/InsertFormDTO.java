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
    private long formid;
    private String formname;
    private String description;
    private float versionnumber;

    private List<FieldsDTO> fieldsList;



}
