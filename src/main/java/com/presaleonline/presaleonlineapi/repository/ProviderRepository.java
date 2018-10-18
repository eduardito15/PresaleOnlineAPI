package com.presaleonline.presaleonlineapi.repository;

import com.presaleonline.presaleonlineapi.domain.Provider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProviderRepository extends CrudRepository<Provider, Long> {

    @Query(value = "SELECT p FROM Provider p left join p.users u WHERE u.id = :userId")
    public Provider getByUser(@Param("userId") Integer userId);

    @Query(value = "SELECT p FROM Provider p left join p.clients c WHERE c.id = :clientId")
    public List<Provider> getByClient(@Param("clientId") Long clientId);

    @Query(value = "SELECT count(o) FROM Orders o WHERE o.provider = :provider")
    public Integer getQuantityPendingOrders(@Param("provider") Provider provider);

}