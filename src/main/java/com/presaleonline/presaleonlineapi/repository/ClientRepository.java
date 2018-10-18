package com.presaleonline.presaleonlineapi.repository;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Hero;
import com.presaleonline.presaleonlineapi.domain.Provider;
import com.presaleonline.presaleonlineapi.domain.ProviderOrderConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query(value = "SELECT c FROM Client c left join c.users u WHERE u.id = :userId")
    public Client getByUser(@Param("userId") Integer userId);

    @Query(value = "SELECT pc FROM ProviderOrderConfig pc WHERE pc.client = :client and pc.provider = :provider")
    public ProviderOrderConfig getProviderOrderConfigByClientAndProvider(@Param("client") Client client, @Param("provider") Provider provider);
}