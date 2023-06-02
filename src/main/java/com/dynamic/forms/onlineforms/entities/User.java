package com.dynamic.forms.onlineforms.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String userfirstname;
    private String userlastname;
    private String useremailid;
    private String username;
    private String userpassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(
                    name = "roleid"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "userid"
            )
    )
    private List<Role> Role;
}
