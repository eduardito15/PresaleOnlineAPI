package com.presaleonline.presaleonlineapi.controller;

import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.StockDTO;
import com.presaleonline.presaleonlineapi.service.ProviderService;
import com.presaleonline.presaleonlineapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private StockService stockService;

    public ProviderController() {

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getProviderClients")
    public @ResponseBody
    List<Client> getProviderClients() {
        return providerService.getProviderClients();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/stock")
    public @ResponseBody List<StockDTO> getClientStock(@RequestParam Long id) {
        // This returns a JSON or XML with the users
        return stockService.getStockDTOByClient(id);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getProviders")
    public @ResponseBody
    List<Provider> getProviders(@RequestHeader HttpHeaders httpHeaders) {
        System.out.println(httpHeaders);
        return providerService.getProvidersByClient();
    }
}
