package com.presaleonline.presaleonlineapi.service;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Provider;
import com.presaleonline.presaleonlineapi.domain.User;

import java.util.List;

public interface ProviderService {

    Provider getById(Long id);

    Provider getByUser(User u);

    List<Provider> getProvidersByClient();

    List<Client> getProviderClients();
}
