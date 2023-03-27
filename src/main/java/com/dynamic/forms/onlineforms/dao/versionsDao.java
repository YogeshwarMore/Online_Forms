package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.versions;
import com.fasterxml.jackson.core.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface versionsDao extends JpaRepository<versions,Long> {
}
