package com.dynamic.forms.onlineforms.controller;

//import com.dynamic.forms.onlineforms.entities.versions;
import com.dynamic.forms.onlineforms.dto.FilledFormDTO;
import com.dynamic.forms.onlineforms.dto.FormVersionDTO;
import com.dynamic.forms.onlineforms.entities.Form;
import com.dynamic.forms.onlineforms.entities.*;

import com.dynamic.forms.onlineforms.services.formsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MyController {
    @Autowired
    private formsServices fs;


    @PostMapping("/form")
    public Form saveForm(@RequestBody Form form) { return this.fs.saveform(form); }

    @GetMapping("/forms")
    public List<Form> getForms()
    {
      return this.fs.getForms();
    }
//
//    @GetMapping("/versions")
//    public List<versions> getVersion()
//    {
//        return this.fs.getVersions();
//    }
//
//
//    @GetMapping("/group")
//    public List<formGroup> getGroup()
//    {
//        return  this.fs.getGroup();
//    }
//    @GetMapping("/field")
//    public List<formField> getField()
//    {
//        return  this.fs.getField();
//    }
//
//    @GetMapping("/filledformfield")
//    public List<filledFormField> filledFormFields(){return fs.getFilledFieldForm();}

    @GetMapping("/form/{Fid}/{vnum}")
    public List<Form> getGroup(@PathVariable Long Fid,@PathVariable Float vnum)
    {
        return  this.fs.getGroup(Fid,vnum);
    }
//    @PutMapping("/group/{Fid}/{vnum}")
//    public List<Form> updateFields(@RequestBody Form form,@PathVariable Long Fid,@PathVariable Float vnum)
//    {
//        return  this.fs.updateField(form,Fid,vnum);
//    }
    @GetMapping("/forms/version")
    public  List<FormVersionDTO> getformversion()
    {
        return fs.getformversion();
    }

    @GetMapping("/filledforms/{id}/{vnum}/{userid}")
    public List<FilledFormDTO> getFilledForm(@PathVariable Long id,@PathVariable Float vnum,@PathVariable Long userid)
    {return fs.getFilledForm(id,vnum,userid); }

    @GetMapping("/forms/{id}")
    public Form getFormById(@PathVariable int id)
    {
        return this.fs.getFormById(id);
    }

    @GetMapping("/form/{id}/{vnum}/{userid}")
    public List<Form> getuserform(@PathVariable Long id,@PathVariable Long vnum,@PathVariable int userid){
        return this.fs.getuserform(id,vnum,userid);
    }

}
