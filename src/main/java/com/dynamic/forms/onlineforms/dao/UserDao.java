package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findById(long id);

}
