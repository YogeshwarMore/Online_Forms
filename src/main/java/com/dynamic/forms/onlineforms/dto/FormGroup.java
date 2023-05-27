package com.dynamic.forms.onlineforms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FormGroup {
    @JsonIgnore
    private long formgroupid;
    private String groupname;
    private int indexs;
    private long versionid;
}
