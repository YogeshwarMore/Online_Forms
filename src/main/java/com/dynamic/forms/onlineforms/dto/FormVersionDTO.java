package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.Versions;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FormVersionDTO {
    private Long formid;
    private String formname;
    private List<Versions> version;


}
