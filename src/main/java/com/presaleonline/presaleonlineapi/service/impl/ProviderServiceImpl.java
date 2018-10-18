package com.presaleonline.presaleonlineapi.service.impl;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Provider;
import com.presaleonline.presaleonlineapi.domain.User;
import com.presaleonline.presaleonlineapi.repository.ProviderRepository;
import com.presaleonline.presaleonlineapi.service.ClientService;
import com.presaleonline.presaleonlineapi.service.ProviderService;
import com.presaleonline.presaleonlineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Override
    public Provider getById(Long id) {
        return providerRepository.findOne(id);
    }

    @Override
    public Provider getByUser(User u) {
        return providerRepository.getByUser(u.getId());
    }

    @Override
    public List<Provider> getProvidersByClient() {
        User user = userService.getLoggedUser();
        Client client = clientService.getByUser(user);
        return providerRepository.getByClient(client.getId());
    }

    @Override
    public List<Client> getProviderClients() {
        User user = userService.getLoggedUser();
        Provider byUser = providerRepository.getByUser(user.getId());
        return byUser.getClients();
    }
}
