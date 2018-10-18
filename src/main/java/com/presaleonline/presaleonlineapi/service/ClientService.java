package com.presaleonline.presaleonlineapi.service;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.User;

public interface ClientService {

    Client getByUser(User u);

    Client getClientById(Long clientId);
}
