package com.dynamic.forms.onlineforms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

//    private User user;
    private String role;
    private String jwtToken;
    private long userid;

}
