package com.presaleonline.presaleonlineapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.presaleonline.presaleonlineapi.domain.User;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String username);

    @Query("SELECT u FROM User u WHERE u.name = :name)")
    User getByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.name = :name)")
    User getByUserName(@Param("name") String name);

}
