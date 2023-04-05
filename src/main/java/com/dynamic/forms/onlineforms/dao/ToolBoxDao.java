package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.ToolBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolBoxDao extends JpaRepository<ToolBox,Long> {
    ToolBox findById(long id);

}
