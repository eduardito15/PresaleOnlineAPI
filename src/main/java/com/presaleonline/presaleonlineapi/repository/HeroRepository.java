package com.presaleonline.presaleonlineapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.presaleonline.presaleonlineapi.domain.Hero;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    @Query("SELECT h FROM Hero h WHERE h.name LIKE %:searchName%)")
    public List<Hero> findByName(@Param("searchName") String searchName);

}