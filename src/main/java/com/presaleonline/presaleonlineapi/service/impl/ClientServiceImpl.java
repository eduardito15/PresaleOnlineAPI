package com.presaleonline.presaleonlineapi.service.impl;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.User;
import com.presaleonline.presaleonlineapi.repository.ClientRepository;
import com.presaleonline.presaleonlineapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getByUser(User u) {
        return clientRepository.getByUser(u.getId());
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findOne(clientId);
    }
}
