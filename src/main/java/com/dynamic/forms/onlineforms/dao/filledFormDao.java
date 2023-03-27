package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.filledForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface filledFormDao extends JpaRepository<filledForm,Long> {
}
