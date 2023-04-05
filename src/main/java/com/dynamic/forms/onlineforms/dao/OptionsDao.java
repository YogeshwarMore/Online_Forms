package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionsDao extends JpaRepository<Options,Long> {

    Options findById(long id);
    Options findByName(String name);

}
