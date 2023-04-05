package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "filledform")
public class FilledForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "filledformid")
    private long filledformid;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "versionid")
    private Versions versionid;
    @Column(name = "userid")
    private long userid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "filldate")
    private Date filldate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filledformid")
    private List<FilledFormField> filledFormFieldList = new ArrayList<>();


}
