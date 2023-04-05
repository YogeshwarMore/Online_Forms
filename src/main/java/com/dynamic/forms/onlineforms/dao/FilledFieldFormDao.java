package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.FilledFormField;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilledFieldFormDao extends JpaRepository<FilledFormField,Long> {

    @Query(value = "SELECT f.filledFormFieldId, f.filledFormId, f.formFieldId, \n" +
            "f.isChecked, f.textValue, f.numericValue, f.dateTimeValue, f.optionId\n" +
            "FROM filledFormField f where f.filledFormId= :id1 ;",nativeQuery = true)
        public List<FilledFormField> getFieldById(@Param("id1") long id);

}
