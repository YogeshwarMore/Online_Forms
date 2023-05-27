package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optionid")
    private long optionId;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "option")
    private List<FormField> formfieldid;


}
