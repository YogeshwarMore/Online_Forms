package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.Form;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VersionsDTO {
    @JsonIgnore
    private Long versionid;
    private float versionnumber;
    private Long formid;
}
