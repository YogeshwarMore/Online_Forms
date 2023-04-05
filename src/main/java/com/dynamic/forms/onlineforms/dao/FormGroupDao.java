package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.FormGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormGroupDao extends JpaRepository<FormGroup,Long> {
    @Query(value = "Select * from formgroup where versionid=:id",nativeQuery = true)
    List<FormGroup> findByGroupId(long id);
    FormGroup findById(long id);

    void deleteById(Long formGroupId);
}
