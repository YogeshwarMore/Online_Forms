package com.dynamic.forms.onlineforms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilledFormDTO {
    private long filledformid;

    private long versionid;

    private int userid;

    private Date filldate;








    }







