package com.dynamic.forms.onlineforms.services;


import com.dynamic.forms.onlineforms.dto.*;
import com.dynamic.forms.onlineforms.entities.*;


import java.util.List;

public interface FormsServices {

    public abstract List<Form> getForms();

    public List<FormVersionDTO> getFormVersion();

    public Form createForm(FormDTO form);

    public FormField createFields(InsertFormDTO form, Long id);

    List<FormFieldDTO> getForm(Long fid, Long vnum);

    Form updateForm(Form form, Long formid);

    Versions updateVersion(Versions version, Long versionid);

    FormField updateField(FormField formfield, Long fieldid);

    Versions createVersion(VersionsDTO v);

    List<GetFilledFormDTO> getFilledForm(Long filledFormId);

     public void deleteForm(Long formid);
    public void delectVersion(Long versionid);
    public FilledForm getFilledForm(FilledFormFieldDTO ffdto,Long versionid, Long userid);
    public void deleteField(Long formGroupId);

    public Form createForms(CreateFormDTO form);

//  public List<Form> getuserform(Long id, Float vnum, Long userid);
}
