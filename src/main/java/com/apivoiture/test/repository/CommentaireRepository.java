package com.apivoiture.test.repository;

import com.apivoiture.test.model.CommentairesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<CommentairesModel, Integer>  {

    @Query("SELECT comm FROM CommentairesModel comm WHERE comm.voiture.id =:id")
    @Transactional(readOnly = true)
    List<CommentairesModel> listCom(@Param("id") Integer id);
}
