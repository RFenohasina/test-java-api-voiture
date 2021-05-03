package com.apivoiture.test.repository;

import com.apivoiture.test.model.VoitureModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<VoitureModel, Integer> {
    @Query("SELECT DISTINCT d FROM VoitureModel d WHERE d.id =:id")
    VoitureModel findVoitureById(@Param("id") Integer id);

    @Query("SELECT v FROM VoitureModel v WHERE v.id =:id")
    List<VoitureModel> listeVoiture(@Param("id") Integer id);
}
