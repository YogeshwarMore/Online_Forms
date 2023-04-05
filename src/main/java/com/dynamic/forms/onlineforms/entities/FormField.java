package com.dynamic.forms.onlineforms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "formfield")
public class FormField {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "formfieldid")
    private Long formfieldid;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "formgroupid", referencedColumnName = "formgroupid")
    private FormGroup formgroupid;

    @Column(name = "fieldname")
    private String fieldname;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "toolid", referencedColumnName = "toolid")
    private ToolBox toolid;
    @Column(name = "indexs")
    private int indexs;
    @Column(name = "isoptional")
    private int isoptional;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "optionformfields",
            joinColumns = @JoinColumn(
                    name = "formfieldid"

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "optionid"

            )
    )
    private List<Options> option;

//    public void addoptions(options op)
//    {
//        if(option == null) option=new ArrayList<>();
//        option.add(op);
//    }

    public List<Options> getOption() {
        return option;
    }

    public void setOption(List<Options> option) {
        this.option = option;
    }

    public long getFormfieldid() {
        return formfieldid;
    }

    public void setFormfieldid(long formfieldid) {
        this.formfieldid = formfieldid;
    }

    public FormGroup getFormgroupid() {
        return formgroupid;
    }

    public void setFormgroupid(FormGroup formgroupid) {
        this.formgroupid = formgroupid;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public ToolBox getToolid() {
        return toolid;
    }

    public void setToolid(ToolBox toolid) {
        this.toolid = toolid;
    }

    public int getIndexs() {
        return indexs;
    }

    public void setIndexs(int indexs) {
        this.indexs = indexs;
    }

    public int getIsoptional() {
        return isoptional;
    }

    public void setIsoptional(int isoptional) {
        this.isoptional = isoptional;
    }


}
