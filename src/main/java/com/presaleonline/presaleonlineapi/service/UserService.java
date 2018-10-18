package com.presaleonline.presaleonlineapi.service;

import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.ClientOrProviderNameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.presaleonline.presaleonlineapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProviderService providerService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void save(User user) {
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        repo.save(user);
    }

    public User getLoggedUser() {
        CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repo.getByUserName(u.getUsername());
    }

    public ClientOrProviderNameDTO getClientOrProviderName() {
        User u = this.getLoggedUser();
        ClientOrProviderNameDTO result = new ClientOrProviderNameDTO();
        if (u != null && u.getUserType().equals(UserType.CLIENT.toString())) {
            Client c = clientService.getByUser(u);
            result.setName(c.getName());
        } else if (u != null && u.getUserType().equals(UserType.PROVIDER.toString())) {
            Provider p = providerService.getByUser(u);
            result.setName(p.getName());
        } else {
            result.setName("");
        }
        return result;
    }
}
