package com.dynamic.forms.onlineforms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormFieldDTO {

    private Long formfieldid;
    @JsonIgnore
    private Long formgroupid;
    private String fieldtype;
    private String fieldName;
    private Long toolid;
    private int indexs;
    private Boolean isoptional;
    private List<String> names;


}
