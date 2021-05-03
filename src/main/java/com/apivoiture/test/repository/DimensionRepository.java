package com.apivoiture.test.repository;

import com.apivoiture.test.model.DimensionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DimensionRepository extends JpaRepository<DimensionModel, Integer> {
    @Query("SELECT DISTINCT d FROM DimensionModel d WHERE d.id =:id")
    DimensionModel findDimensionById(@Param("id") Integer id);
}
