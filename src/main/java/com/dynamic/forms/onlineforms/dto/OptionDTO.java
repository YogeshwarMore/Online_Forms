package com.dynamic.forms.onlineforms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OptionDTO {
    @JsonIgnore
    private Long optionid;
    private String name;
}
