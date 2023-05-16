package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.FormGroup;
import com.dynamic.forms.onlineforms.entities.Versions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormGroupDao extends JpaRepository<FormGroup,Long> {
    @Query(value = "\n" +
            "Select fg.formgroupid, fg.name ,fg.indexs, fg.versionid from formgroup fg where fg.versionid=:id",nativeQuery = true)
    List<FormGroup> findByGroupId(@Param("id")long id);
    FormGroup findById(long id);

    void deleteById(Long formGroupId);
}


