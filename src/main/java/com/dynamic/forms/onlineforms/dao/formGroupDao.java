package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.FormGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface formGroupDao extends JpaRepository<FormGroup,Long> {
}
