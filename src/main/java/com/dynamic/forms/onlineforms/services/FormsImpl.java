package com.dynamic.forms.onlineforms.services;
import com.dynamic.forms.onlineforms.dao.*;
import com.dynamic.forms.onlineforms.dto.*;
import com.dynamic.forms.onlineforms.entities.*;
import com.dynamic.forms.onlineforms.entities.FormGroup;
import com.dynamic.forms.onlineforms.exceptions.MyCustomException;
import com.dynamic.forms.onlineforms.helper.FilledData;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormsImpl implements FormsServices {


    //<editor-fold desc="Dao Autowired">
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FormsDao formsdao;
    @Autowired
    private UserDao userdao;
    @Autowired
    private FormGroupDao formgroupdao;
    @Autowired
    private VersionsDao versionsdao;
    @Autowired
    private FormFieldDao formfielddao;
    @Autowired
    private FilledFormDao filledformdao;
    @Autowired
    private FilledFieldFormDao filledfieldformdao;
    @Autowired
    private ToolBoxDao toolBoxDao;
    @Autowired
    private OptionsDao optionsDao;
    @Autowired
    private OptionFormFieldsDao optionFormFieldsDao;
    @Autowired
    private UserDao userDao;
    //</editor-fold>


    public Form createForms(CreateFormDTO form){

        Form f = new Form();
        if(form.getFormname() !=null && form.getDescription()!=null)
        {
            f.setFormname(form.getFormname());
            f.setDescription(form.getDescription());
            f.setChangedate(Date.valueOf(LocalDate.now()));
            f.setCreationdate(f.getChangedate());
            f = formsdao.save(f);


            Versions vv = new Versions();
            if((Float)form.getVersionnumber() != null)
            {
            vv.setVersionnumber(form.getVersionnumber());

            vv.setFormid(f);
            vv = versionsdao.save(vv);

            FormGroup fg = new FormGroup();
            fg.setIndexs(1);
            fg.setName("FG1");
            fg.setVersionid(vv);
            fg = formgroupdao.save(fg);


            for(CreateFormFieldDTO ffdto: form.getFields())
            {
                FormField ff=new FormField();
                ff.setFieldname(ffdto.getFieldname());
                ff.setIndexs(ffdto.getIndexs());
                if(ffdto.getIsoptional())
                    ff.setIsoptional(1);
                else
                    ff.setIsoptional(0);
                ff.setToolid(toolBoxDao.findById(ffdto.getToolid()));
                ff.setFormgroupid(fg);
                ff=formfielddao.save(ff);

                Options op = new Options();

                if(ffdto.getToolid()==2 || ffdto.getToolid()==3)
                for (Options o : ffdto.getOptions()) {

                    if (o.getName() != null) {
                        if (optionsDao.findByName(o.getName()) != null) {

                            op = optionsDao.findByName(o.getName());
                        } else {
                            Options p = new Options();
                            p.setName(o.getName());
                            op = optionsDao.save(p);
                        }
                    }
                    OptionFormFields of = new OptionFormFields();{
                    of.setFormField(ff);
                    of.setOption(op);
                    }

                    optionFormFieldsDao.save(of);
                }

            }

        //version end;
        }else throw new MyCustomException("Null value Not Allowed");

        //form end
        }else throw new MyCustomException("Null value Not Allowed");

        return f;

    }

    //<editor-fold desc="Get Functions">


    @Override
    public void createUser(User user) {
        this.userDao.save((user));
    }

    @Override
    public List<Form> getForms() {
        return (List<Form>) formsdao.findAll();
    }



    @Override
    public List<FormFieldDTO> getForm(long fid, long vnum) {

        //formsdao.getform(fid,vnum).get(0).getFormid();
        List<FormFieldDTO> fgdto = new ArrayList<>();
        List<OptionFormFields> off = new ArrayList<>();


        for (FormGroup fg : formgroupdao.findByGroupId(vnum)) {
            for (FormField ff : formfielddao.FindByFGId(fg.getFormgroupid())) {


                FormFieldDTO ffd = new FormFieldDTO();

                ffd.setFormfieldid(ff.getFormfieldid());
                ffd.setFieldName(ff.getFieldname());
                ffd.setFormgroupid(ff.getFormgroupid().getFormgroupid());
                ffd.setToolid(ff.getToolid().getId());
                ffd.setIndexs(ff.getIndexs());
                if (ff.getIsoptional() == 0)
                    ffd.setIsoptional(false);
                else
                    ffd.setIsoptional(true);
                ffd.setFieldtype(ff.getToolid().getName());

                if (ffd.getToolid() == 2 || ffd.getToolid() == 3) {

                    off = optionFormFieldsDao.getOptionByField(ff.getFormfieldid());

                    List<String> nm = new ArrayList<>();
                    for (OptionFormFields of : off) {
                        nm.add(of.getOption().getName());

                    }
                        ffd.setNames(nm);
                }

                fgdto.add(ffd);

            }
        }

        return fgdto;
    }

    @Override
    public List<FormVersionDTO> getFormVersion() {
        List<FormVersionDTO> formver = new ArrayList<>();

//        for (Form form_obj : formsdao.findAll()){
//            List<Float> versionnumber=new ArrayList<>();
//            for(versions v : form_obj.getVersionsList()) {
//
//                if (v.getFormid().getFormid()== form_obj.getFormid()){
//
//                    versionnumber.add(v.getVersionnumber());
//                }
//            }
//          //  formver.add(new FormVersionDTO(form_obj.getFormname(), versionnumber));
//
//        }
        List<Form> form = new ArrayList<>();
        form = (List<Form>) formsdao.findAll();
        Versions v1 = new Versions();
        for (Form f : form) {
            FormVersionDTO fv = this.modelMapper.map(f, FormVersionDTO.class);
            fv.setVersion(f.getVersionsList());

            formver.add(fv);
        }

        return formver;
    }
    @Override
    public List<ToolBox> getToolBox()
    {
       return toolBoxDao.findAll();
    }

    @Override
    public long getOptionid(String name) {

        return  optionsDao.findByName(name).getOptionId();
    }
    //</editor-fold>

    //<editor-fold desc="Create Functions">
    @Override
    public Form createForm(FormDTO form) {

        Form f = this.modelMapper.map(form, Form.class);
        f.setChangedate(java.sql.Date.valueOf(java.time.LocalDate.now()));
        f.setCreationdate(f.getChangedate());
        f = formsdao.save(f);

        return f;
    }




    @Override
    public Versions createVersion(VersionsDTO v) {

        Versions vv = new Versions();

        Form f = formsdao.findById((long) v.getFormid());
        vv.setVersionnumber(v.getVersionnumber());

        vv.setFormid(f);
        vv = versionsdao.save(vv);

        FormGroup fg = new FormGroup();
        fg.setIndexs(1);
        fg.setName("FG1");
        fg.setVersionid(vv);
        fg = formgroupdao.save(fg);
        return vv;
    }

    @Override
    public Form getformdetails(long f) {
        return formsdao.findById((long)f);
    }

    @Override
    public FormField createFields(InsertFormDTO form) {

        Form f = new Form();
        Versions vv = new Versions();
        FormGroup fg = new FormGroup();
        FormField ff =new FormField();

        if(form.getFormname() !=null && form.getDescription()!=null)
        {
            if((Long)form.getFormid()!=null){
            f.setFormid(form.getFormid());

            }
            f.setFormname(form.getFormname());
            f.setDescription(form.getDescription());
            f.setChangedate(Date.valueOf(LocalDate.now()));
            f.setCreationdate(f.getChangedate());
            f = formsdao.save(f);


            if((Float)form.getVersionnumber() != null) {
                vv.setVersionnumber(form.getVersionnumber());
                vv.setFormid(f);
                vv = versionsdao.save(vv);

                System.out.println(vv.getFormid().getFormid());
                fg.setIndexs(1);
                fg.setName("FG1");
                fg.setVersionid(vv);
                fg = formgroupdao.save(fg);


                for (FieldsDTO form1 : form.getFieldsList()) {
                    ToolBox tb = toolBoxDao.findById((long) form1.getToolid());
                    ff = this.modelMapper.map(form, FormField.class);
                    ff.setFieldname(form1.getFieldName());
                    ff.setIndexs(form1.getIndexs());

                    if (form1.getIsoptional())
                        ff.setIsoptional(1);
                    else
                        ff.setIsoptional(0);
                    ff.setFormgroupid(fg);
                    ff.setToolid(tb);

                    ff = formfielddao.save(ff);

                    ff = addoption(ff, form1);
                }
            }
        }
        return ff;
    }

    public FormField addoption(FormField ff, FieldsDTO form){
            Options op = new Options();
            if(form.getNames()==null)
                return null;
            for (String o : form.getNames()) {

                if (o != null) {
                    if (optionsDao.findByName(o) != null) {

                        op = optionsDao.findByName(o);

                    } else {
                        Options p = new Options();
                        p.setName(o);
                        op = optionsDao.save(p);
                    }
                }
                OptionFormFields of = new OptionFormFields();
                of.setFormField(ff);
                of.setOption(op);

                optionFormFieldsDao.save(of);
            }

        return ff;
    }
    //</editor-fold>

    //<editor-fold desc="update functions">
    @Override
    public Form updateForm(Form form, long formid) {

        Form f = formsdao.findById((long) formid);
        f = modelMapper.map(f, Form.class);
        f.setFormname(form.getFormname());
        f.setDescription(form.getDescription());
        f.setChangedate(Date.valueOf(LocalDate.now()));
        formsdao.save(f);

        return form;
    }

    @Override
    public Versions updateVersion(Versions version, long versionid) {
        Versions vs = versionsdao.findById((long) versionid);
        vs = modelMapper.map(vs, Versions.class);
        vs.setVersionnumber(version.getVersionnumber());
        versionsdao.save(vs);

        return vs;
    }

    @Override
    public FormField updateField(FormField formfield, long fieldid) {
        FormField ff = formfielddao.findById((long) fieldid);
        ff = modelMapper.map(ff, FormField.class);
        if (formfield.getFieldname() != null)
            ff.setFieldname(formfield.getFieldname());

        if ((Integer) formfield.getIsoptional() != null)
            ff.setIsoptional(formfield.getIsoptional());

        if ((Integer) formfield.getIndexs() != null)
            ff.setIndexs(formfield.getIndexs());

        if (ff.getToolid().getId() == 2 || ff.getToolid().getId() == 3) {
            List<OptionFormFields> off = optionFormFieldsDao.getOptionByField(ff.getFormfieldid());
            off.stream().filter(p -> {
                optionFormFieldsDao.delete(p);
                return true;
            });
            ff.setOption(formfield.getOption());

        }

        formfielddao.save(ff);
        return ff;
    }
    //</editor-fold>

    //<editor-fold desc="Delete Function">
    @Override
    public void deleteForm(long formid) {      formsdao.deleteById(formid);     }

    @Override
    public void delectVersion(long versionid)
    {
        versionsdao.deleteById(versionid);
    }

    @Override
    public void deleteField(long formGroupId) { formgroupdao.deleteById(formGroupId); }

    //</editor-fold>

    //<editor-fold desc="Filled Form Post & Get">
    @Override
    public List<GetFilledFormDTO> getFilledForm(long versionId) {

        List<FilledForm> ff = filledformdao.findByVersion(versionId);

        List<GetFilledFormDTO> gff = new ArrayList<>();

        for (FilledForm f : ff) {

            GetFilledFormDTO gffdto = new GetFilledFormDTO();

            gffdto.setUser(userDao.findById(f.getUserid()));

            gffdto.setFilldate(f.getFilldate());

            List<FilledFormField> fff = filledfieldformdao.getFieldById(f.getFilledformid());

            List<FilledData> fdlist = new ArrayList<>();


            for (FilledFormField ff1 : fff) {
                String s = new String();

                FilledData fd = new FilledData();

                fd.setFieldname(ff1.getFormfieldid().getFieldname());

                if (ff1.getDatetimevalue() != null)
                    fd.setValue(ff1.getDatetimevalue().toString());

                else if ((Long)ff1.getNumericvalue() != null && ff1.getNumericvalue() != 0)
                    fd.setValue(ff1.getNumericvalue()+"");

                else if (ff1.getDatetimevalue() != null)
                    fd.setValue(ff1.getTextvalue());

                else if (ff1.getIschecked() != null) {
                    s += ff1.getOptionid().getName();
                    fd.setValue(s);
                } else
                    fd.setValue(ff1.getTextvalue());
                fdlist.add(fd);
            }
            gffdto.setDetails(fdlist);
            gff.add(gffdto);
        }
        return gff;
    }

    @Override
    public FilledForm getFilledForm(List<FilledFormFieldDTO> ffd,long versionid, long userid) {

        List<FilledFormField> ff1 = new ArrayList<>();

        FilledForm ff = new FilledForm();
        ff.setUserid(userid);
        ff.setVersionid(versionsdao.findById((long)versionid));
        ff.setFilldate(java.sql.Date.valueOf(java.time.LocalDate.now()));
        ff = filledformdao.save(ff);

        for(FilledFormFieldDTO ffdto:ffd) {

            FilledFormField fff = new FilledFormField();
            fff.setFormfieldid(formfielddao.findById(ffdto.getFormfieldid()));
            fff.setFilledformid(ff);
            if (ffdto.getTextvalue() != null){
                fff.setTextvalue(ffdto.getTextvalue());
                System.out.println(fff.getTextvalue());
            }
             if (ffdto.getIschecked() != null && ffdto.getIschecked() != 0) {
                fff.setIschecked(ffdto.getIschecked());
                fff.setOptionid(optionsDao.findById( ffdto.getOptionid()));
                System.out.println(fff.getOptionid());
            }
            else if ((Long)ffdto.getNumericvalue() != null)
                fff.setNumericvalue(ffdto.getNumericvalue());
            else
                fff.setDatetimevalue(ffdto.getDatetimevalue());
            ff1.add(fff);
        }
        filledfieldformdao.saveAll(ff1);

        return ff;
    }
    // </editor-fold>




//------------------------------------------------------------------------------


    public List<Form> updateField(Form form, long id, Float vnum) {
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


    //End of class
}

