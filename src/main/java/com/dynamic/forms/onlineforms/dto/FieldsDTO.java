package com.dynamic.forms.onlineforms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldsDTO {
    int indexs ;
    String fieldName;
    Boolean isoptional;
    Long toolid;
    List<String> names;
}
