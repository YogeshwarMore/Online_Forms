package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.FilledForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilledFormDao extends JpaRepository<FilledForm,Long> {

    public FilledFormDao findById(long id);

    @Query(value = "select ff.filledformid, ff.userid,ff.filldate,ff.versionid from filledform ff where versionid= :id1",nativeQuery = true)
    List<FilledForm> findByVersion(@Param("id1") Long versionid);


}
