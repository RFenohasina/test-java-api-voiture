package com.apivoiture.test.repository;

import com.apivoiture.test.model.MoteurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MoteurRepository extends JpaRepository<MoteurModel, Integer> {
    @Query("SELECT DISTINCT m FROM MoteurModel m WHERE m.id =:id")
    MoteurModel findMoteurById(@Param("id") Integer id);
}
