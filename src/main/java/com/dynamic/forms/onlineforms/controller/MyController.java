package com.dynamic.forms.onlineforms.controller;

//import com.dynamic.forms.onlineforms.entities.versions;
import com.dynamic.forms.onlineforms.dto.*;
import com.dynamic.forms.onlineforms.entities.Form;
import com.dynamic.forms.onlineforms.entities.*;

import com.dynamic.forms.onlineforms.services.FormsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class MyController {
    @Autowired
    private FormsServices fs;

    //<editor-fold desc="Post Mapping Form">

    @PostMapping("/Forms")
        public Form createForms(
                @RequestBody  CreateFormDTO obj)
        {
            return fs.createForms(obj);
        }


    @PostMapping("/forms")

    public ResponseEntity<Form> createForm(
            @RequestBody FormDTO form) {

        return new ResponseEntity<>(fs.createForm(form), HttpStatus.CREATED);
    }



    @PostMapping("/forms/creating")

    public ResponseEntity<FormField> createFields
            (@RequestBody InsertFormDTO form) {

        return new ResponseEntity<>(fs.createFields(form), HttpStatus.CREATED);
    }

//    @PostMapping("/forms")
//    public ResponseEntity<Versions> createVersion(
//            @RequestBody VersionsDTO version) {
//
//    return new ResponseEntity<>(fs.createVersion(version), HttpStatus.CREATED);
//    }
    //</editor-fold>

    //<editor-fold desc="Get Mapping Form">
    @GetMapping("/forms/version")
    public  List<FormVersionDTO> getFormVersion() {

        return fs.getFormVersion();
    }

    @GetMapping("/tools")
    public List<ToolBox> gettoolbox() {
        return this.fs.getToolBox();
    }

    @GetMapping("/forms")
    public List<Form> getForms() {

        return this.fs.getForms();
    }

    @GetMapping("/forms/formid/{Fid}/versionid/{vid}")
    public List<FormFieldDTO> getForm(
            @PathVariable Long Fid,
            @PathVariable Long vid) {
        return  this.fs.getForm(Fid,vid);
    }
    //</editor-fold>

    //<editor-fold desc="Put Mapping Form">
    @PutMapping("/forms/{formid}")
    public Form updateForm(@RequestBody Form form,@PathVariable Long formid)
    {
        return fs.updateForm(form,formid);
    }

    @PutMapping("/forms/version/{versionid}")
    public Versions updateVersion(@RequestBody Versions version, @PathVariable Long versionid)
    {
        return fs.updateVersion(version,versionid);
    }

    @PutMapping("/forms/field/{fieldid}")
    public FormField updateField(@RequestBody FormField formfield,@PathVariable Long fieldid )
    {
        return fs.updateField(formfield,fieldid);
    }
    //</editor-fold>

    //<editor-fold desc="Delete Mapping Form">
    @DeleteMapping("forms/{formid}")
    public void deleteForm(@PathVariable Long formid)
    {
        fs.deleteForm(formid);
    }

    @DeleteMapping("forms/{versionid}")
    public void deleteVersion(@PathVariable Long versionid){
        fs.delectVersion(versionid);
    }
    @DeleteMapping("/forms/{formgroup}")
    public void deletefield(@PathVariable Long formGroupId)
    {
        fs.deleteField(formGroupId);
    }
    //</editor-fold>

    @GetMapping("forms/{filledFormId}")
    public List<GetFilledFormDTO> getFilledForm(@PathVariable Long filledFormId){

        return fs.getFilledForm(filledFormId);
    }
    @PostMapping("forms/{versionid}/{userid}")
    public FilledForm getFilledForm(@RequestBody FilledFormFieldDTO ffdto,@PathVariable  Long versionid,@PathVariable  Long userid)
    {
        return fs.getFilledForm(ffdto,versionid,userid);
    }


}
