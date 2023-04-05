package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.FormField;

import com.dynamic.forms.onlineforms.entities.FormGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormFieldDao extends JpaRepository<FormField,Long> {

    @Query(value = "Select ff.formfieldid,ff.formgroupid,ff.toolid,ff.fieldname ,ff.indexs,ff.isoptional from formfield ff where formgroupid=:id",nativeQuery = true)
    List<FormField> FindByFGId(long id);

    FormField findById(long fieldid);

}

