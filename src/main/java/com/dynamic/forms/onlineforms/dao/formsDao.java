package com.dynamic.forms.onlineforms.dao;

import com.dynamic.forms.onlineforms.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface formsDao extends CrudRepository<Form,Long> {


      Form findByFormid(int i);
//    @Query("Select f.formname ,v.versionnumber from form f JOIN f.versions v")
//    public List<Form> getforminfo();

//      @Query(value = "\n" +
//              "SELECT * FROM Form a  inner join versions b on a.formid=b.formid where a.formid = :id1 AND b.versionid = :id2\n",nativeQuery = true)
//      List<Form> getGroup(@Param("id1") Long id1, @Param("id2") Float id2);

      @Query(value = "SELECT a.* FROM Form a INNER JOIN versions b ON a.formid = b.formid WHERE a.formid = :id1 AND b.versionid = :id2", nativeQuery = true)
      List<Form> getGroup(@Param("id1") Long id1, @Param("id2") Float id2);

      @Query(value = "    SELECT  f.formId AS formId_f, ff1.formId AS formId_ff1, v.versionid, ff1.userid \n" +
              "              FROM form f\n" +

              "              JOIN versions v ON v.formid = f.formid\n" +
              "              JOIN filledForm ff1 \n"+
              "              WHERE v.versionid = 1 AND ff1.userid = 1\n" +
              "              ",nativeQuery = true)
      List<Form> getfilledform(@Param("id1") Long id,@Param ("id2")Long vnum,@Param("id3") int userid);

}
