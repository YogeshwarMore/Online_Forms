package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.dto.FormDTO;
import com.dynamic.forms.onlineforms.dto.FormFieldDTO;
import com.dynamic.forms.onlineforms.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormsDao extends CrudRepository<Form,Long> {


      Form findById(long id);



      @Query(value = " \n" +
              "SELECT \n" +
              "  f.formId, \n" +
              "  f.formName as formname, \n" +
              "  f.Description, \n" +
              "  f.creationDate, \n" +
              "  f.changeDate, \n" +
              "  v.versionid,\n" +
              "  v.versionNumber as versionnumber,\n" +
              "  fg.formGroupId,\n" +
              "  fg.Name AS formGroupName,\n" +
              "  fg.Indexs AS formGroupIndex,\n" +
              "  ff.formFieldId,\n" +
              "  ff.fieldName,\n" +
              "  ff.toolId,\n" +
              "  ff.Indexs AS formFieldIndex,\n" +
              "  ff.isOptional AS formFieldIsOptional,\n" +
              "  off.optionFormFieldsid,\n" +
              "  OP.optionId,\n" +
              "  OP.name AS optionName\n" +
              "FROM \n" +
              "  Form f\n" +
              "  JOIN versions v ON v.formId = f.formId\n" +
              "  JOIN formGroup fg ON fg.versionid = v.versionid\n" +
              "  JOIN formField ff ON ff.formGroupId = fg.formGroupId\n" +
              "  LEFT JOIN optionFormFields off ON off.formFieldId = ff.formFieldId\n" +
              "  LEFT JOIN options OP ON OP.optionId = off.optionId\n" +
              "WHERE \n" +
              "  f.formId = :id1 AND \n" +
              "  v.versionid = :id2 \n" +
              "\n ",nativeQuery = true)
      List<FormDTO> getform(@Param("id1") long id, @Param ("id2")Float vnum);

      @Query(value = "SELECT a.* FROM Form a INNER JOIN versions b ON a.formid = b.formid WHERE a.formid = :id1 AND b.versionid = :id2", nativeQuery = true)
      List<Form> getGroup(@Param("id1") long id1, @Param("id2") Float id2);

}
