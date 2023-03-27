package com.dynamic.forms.onlineforms.services;

import com.dynamic.forms.onlineforms.dao.*;
import com.dynamic.forms.onlineforms.dto.FilledFormDTO;
import com.dynamic.forms.onlineforms.dto.FormVersionDTO;
import com.dynamic.forms.onlineforms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class formsImpl implements formsServices{

    @Autowired
    formsDao formsdao;
    @Autowired
    formGroupDao formgroupdao;
    @Autowired
    versionsDao versionsdao;

    @Autowired
    formFieldDao formfielddao;

    @Autowired
    filledFormDao filledformdao;
    @Autowired
    filledFieldFormDao filledfieldformdao;

    @Override
    public  List<Form> getForms() {
        return (List<Form>) formsdao.findAll();
    }

    @Override
    public List<versions> getVersions() {
        return versionsdao.findAll();
    }





//    @Override
//    public List<filledForm> getFilledForm() {
//        return filledformdao.findAll();
//    }
public List<Form> updateField(Form form,Long id,Float vnum){
//        List<Form> list=new ArrayList<>();
//        list = formsdao.getGroup(id,vnum);
//
//       return list.stream().map(b->{
//            b.setChangedate(form.getChangedate());
//            return b;
//        }).collect(Collectors.toList());

    List<Form> forms = formsdao.getGroup(id, vnum);

    // Iterate over the fetched forms and update their versionsList field
    for (Form fetchedForm : forms) {
        fetchedForm.setChangedate(form.getChangedate());
    }

    // Save the updated forms to the database
    return (List<Form>) formsdao.saveAll(forms);

}
    @Override
    public List<formField> getField() {
        return formfielddao.findAll();
    }

    @Override
    public List<filledFormField> getFilledFieldForm() {
        return filledfieldformdao.findAll();
    }



    @Override
    public Form saveform(Form form) {
        return formsdao.save(form);
    }

    @Override
    public List<FormVersionDTO> getformversion()
    {
        List<FormVersionDTO> formver =new ArrayList<>();


        for (Form form_obj : formsdao.findAll()){
            List<Float> versionnumber=new ArrayList<>();
        for(versions v : form_obj.getVersionsList()) {

            if (v.getFormid().getFormid()== form_obj.getFormid())

                versionnumber.add(v.getVersionnumber());
        }
        formver.add(new FormVersionDTO(form_obj.getFormname(), versionnumber));

        }
        return formver;
    }

    public List<FilledFormDTO> getFilledForm(Long id,Float vnum ,Long userid)
    {
        List<FilledFormDTO> filledFormDTOS=new ArrayList<>();
        for(Form form_obj : formsdao.getGroup(id,vnum)){
            for (filledForm ff : form_obj.getFilledFormList())
                if(ff.getUserid() == userid)
               filledFormDTOS.add(new FilledFormDTO(form_obj.getFormname(),form_obj.getDescription(),form_obj.getFilledFormList()));

        }
        return filledFormDTOS;
    }


    @Override
    public Form getFormById(int id) {
        return formsdao.findByFormid(id);
    }

    @Override
    public List<Form> getuserform(Long id, Long vnum, int userid) {
        return formsdao.getfilledform(id,vnum,userid);


    }

    public List<Form> getGroup(Long Fid, Float vnum) {
        return formsdao.getGroup(Fid,vnum);
    }



    //End of class
    }

