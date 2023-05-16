package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.Versions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionsDao extends CrudRepository<Versions,Long> {

    Versions findById(long id);

    @Query(value = "SELECT v.versionid, v.versionnumber,v.formid FROM Versions v WHERE v.formid = :formid",nativeQuery = true)
    List<Versions> findByFormId(@Param("formid") Long id);





}
