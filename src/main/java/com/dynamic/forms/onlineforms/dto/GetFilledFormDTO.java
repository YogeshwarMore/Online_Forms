package com.dynamic.forms.onlineforms.dto;

import com.dynamic.forms.onlineforms.entities.User;
import com.dynamic.forms.onlineforms.helper.FilledData;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFilledFormDTO {

    private User user;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date filldate;
    private List<FilledData> Details;

}
