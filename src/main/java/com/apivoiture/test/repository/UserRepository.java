package com.apivoiture.test.repository;

import com.apivoiture.test.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query("SELECT DISTINCT u FROM UserModel u WHERE u.id =:id")
    UserModel findUserById(@Param("id") Integer id);
}
