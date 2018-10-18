package com.presaleonline.presaleonlineapi.controller;

import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.ClientOrProviderNameDTO;
import com.presaleonline.presaleonlineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {


    @Autowired UserService userService;

    public UserController() {
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/userByName")
    public @ResponseBody User getUserByName() {
        return userService.getLoggedUser();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/workname")
    public @ResponseBody
    ClientOrProviderNameDTO getClientOrProviderName() {
        return userService.getClientOrProviderName();
    }


}
