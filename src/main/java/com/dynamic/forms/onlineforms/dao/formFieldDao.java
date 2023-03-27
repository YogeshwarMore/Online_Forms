package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.formField;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface formFieldDao extends JpaRepository<formField,Long> {
}

