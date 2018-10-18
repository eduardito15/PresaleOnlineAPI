package com.presaleonline.presaleonlineapi.repository;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Orders;
import com.presaleonline.presaleonlineapi.domain.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Long> {

    @Query(value = "SELECT o FROM Orders o WHERE o.client = :client")
    public List<Orders> getOrdersByClient(@Param("client") Client client);

    @Query(value = "SELECT o FROM Orders o WHERE o.provider = :provider")
    public List<Orders> getOrdersByProvider(@Param("provider") Provider provider);

}