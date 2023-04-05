package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.Options;
import com.dynamic.forms.onlineforms.entities.ToolBox;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateFormFieldDTO {
    private String fieldname;
    private Long toolid;
    private int indexs;
    private Boolean isoptional;
    private List<com.dynamic.forms.onlineforms.entities.Options> Options;
}
