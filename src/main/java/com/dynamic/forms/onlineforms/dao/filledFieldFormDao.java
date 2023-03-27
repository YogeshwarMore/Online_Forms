package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.filledFormField;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface filledFieldFormDao extends JpaRepository<filledFormField,Long> {
}
