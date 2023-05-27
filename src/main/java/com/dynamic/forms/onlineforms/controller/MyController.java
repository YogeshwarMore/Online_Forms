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
    @PostMapping("forms/{versionid}/{userid}")
    public FilledForm getFilledForm(@RequestBody List<FilledFormFieldDTO> ffdto,@PathVariable  long versionid,@PathVariable  long userid)
    {
        return fs.getFilledForm(ffdto,versionid,userid);
    }

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


    @GetMapping("forms/details/{id}")
        public Form getform(@PathVariable long id){
        return fs.getformdetails(id);
    }
    @GetMapping("forms/{versionid}")
    public List<GetFilledFormDTO> getFilledForm(@PathVariable long versionid){

        return fs.getFilledForm(versionid);
    }


    @GetMapping("/forms/options/{name}")
    public long getOptionid(@PathVariable String name)
    {
        return fs.getOptionid(name);
    }
    @GetMapping("/forms/version/")
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
            @PathVariable long Fid,
            @PathVariable long vid) {
        return  this.fs.getForm(Fid,vid);
    }
    //</editor-fold>

    //<editor-fold desc="Put Mapping Form">
    @PutMapping("/forms/{formid}")
    public Form updateForm(@RequestBody Form form,@PathVariable long formid)
    {
        return fs.updateForm(form,formid);
    }

    @PutMapping("/forms/version/{versionid}")
    public Versions updateVersion(@RequestBody Versions version, @PathVariable long versionid)
    {
        return fs.updateVersion(version,versionid);
    }

    @PutMapping("/forms/field/{fieldid}")
    public FormField updateField(@RequestBody FormField formfield,@PathVariable long fieldid )
    {
        return fs.updateField(formfield,fieldid);
    }
    //</editor-fold>

    //<editor-fold desc="Delete Mapping Form">
    @DeleteMapping("forms/{formid}")
    public void deleteForm(@PathVariable long formid)
    {
        fs.deleteForm(formid);
    }

    @DeleteMapping("forms/{versionid}")
    public void deleteVersion(@PathVariable long versionid){
        fs.delectVersion(versionid);
    }
    @DeleteMapping("/forms/{formgroup}")
    public void deletefield(@PathVariable long formGroupId)
    {
        fs.deleteField(formGroupId);
    }
    //</editor-fold>


}
