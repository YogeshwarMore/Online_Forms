package com.dynamic.forms.onlineforms.services;


import com.dynamic.forms.onlineforms.dto.FilledFormDTO;
import com.dynamic.forms.onlineforms.dto.FormVersionDTO;
import com.dynamic.forms.onlineforms.entities.*;


import java.util.List;

public interface formsServices {

public abstract List<Form> getForms();

public List<versions> getVersions();
public List<Form> getGroup(Long id,Float vnum);
  public List<Form> updateField(Form form,Long id,Float vnum);
  public List<FormVersionDTO> getformversion();

//public List<filledForm> getFilledForm();
  public  List<formField> getField();
  public List<filledFormField> getFilledFieldForm();



  public Form saveform(Form form);

  public List<FilledFormDTO> getFilledForm(Long id,Float vnum ,Long userid);

  public Form getFormById(int id);

  public List<Form> getuserform(Long id, Long vnum, int userid);
}
