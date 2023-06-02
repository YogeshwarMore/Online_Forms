package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Long> {

    User findById(long id);

    User findByUseremailid(String useremailid);

}
