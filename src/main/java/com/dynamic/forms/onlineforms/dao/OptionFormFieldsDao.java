package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.OptionFormFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionFormFieldsDao extends JpaRepository<OptionFormFields,Long> {

    @Query(value = "\n" +
            "select off.optionformfieldsid,off.formfieldid,off.optionid from optionformfields off where off.formfieldid= :id1 ",nativeQuery = true)
    List<OptionFormFields> getOptionByField(@Param("id1") Long fieldid);

}
