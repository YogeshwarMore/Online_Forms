package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optionid")
    private Long optionId;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "option")
    private List<FormField> formfieldid;


}
