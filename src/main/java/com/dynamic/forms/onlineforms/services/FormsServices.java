package com.dynamic.forms.onlineforms.services;


import com.dynamic.forms.onlineforms.dto.*;
import com.dynamic.forms.onlineforms.entities.*;


import java.util.List;

public interface FormsServices {

    public void createUser(User user);
    public abstract List<Form> getForms();

    List<FormFieldDTO> getForm(long fid, long vnum);

    public List<FormVersionDTO> getFormVersion();

    public Form createForm(FormDTO form);

    Form updateForm(Form form, long formid);

    Versions updateVersion(Versions version, long versionid);

    FormField updateField(FormField formfield, long fieldid);

    Versions createVersion(VersionsDTO v);
    Form getformdetails(long f);
    List<GetFilledFormDTO> getFilledForm(long filledFormId);
    public FormField createFields(InsertFormDTO form);
     public void deleteForm(long formid);
    public void delectVersion(long versionid);
    public FilledForm getFilledForm(List<FilledFormFieldDTO> ffdto,long versionid, long userid);
    public void deleteField(long formGroupId);

    public Form createForms(CreateFormDTO form);

    public List<ToolBox> getToolBox();

    public long getOptionid(String name);


//  public List<Form> getuserform(Long id, Float vnum, Long userid);
}
