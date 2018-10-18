package com.presaleonline.presaleonlineapi.repository;

import com.presaleonline.presaleonlineapi.domain.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Provider, Long> {



}