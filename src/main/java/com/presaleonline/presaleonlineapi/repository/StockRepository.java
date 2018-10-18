package com.presaleonline.presaleonlineapi.repository;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends CrudRepository<Stock, Long> {

    @Query(value = "SELECT s FROM Stock s WHERE s.client = :client")
    public Stock getStockByClient(@Param("client") Client client);

}