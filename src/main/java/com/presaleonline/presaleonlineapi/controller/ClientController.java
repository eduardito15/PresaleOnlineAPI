package com.presaleonline.presaleonlineapi.controller;

import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.OrderArticleDetailDTO;
import com.presaleonline.presaleonlineapi.dto.StockDTO;
import com.presaleonline.presaleonlineapi.repository.*;
import com.presaleonline.presaleonlineapi.service.OrderService;
import com.presaleonline.presaleonlineapi.service.StockService;
import com.presaleonline.presaleonlineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProviderOrderConfigRepository providerOrderConfigRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockService stockService;

    @Autowired
    private OrderService orderService;

    public ClientController() {
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client-provider/getProviderConfig")
    public @ResponseBody ProviderOrderConfig getProviderOrderConfig(@RequestBody Provider provider) {
        // This returns a JSON or XML with the users
        User user = userService.getLoggedUser();
        Client client = clientRepository.getByUser(user.getId());
        ProviderOrderConfig pOrderConfig = clientRepository.getProviderOrderConfigByClientAndProvider(client, provider);
        if(pOrderConfig == null) {
            pOrderConfig = new ProviderOrderConfig();
            pOrderConfig.setClient(client);
            pOrderConfig.setProvider(provider);
        }
        return pOrderConfig;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client-provider/updateProviderConfig")
    public @ResponseBody ProviderOrderConfig updateProviderOrderConfig(@RequestBody ProviderOrderConfig providerOrderConfig) {
        // This returns a JSON or XML with the users
        providerOrderConfigRepository.save(providerOrderConfig);
        return  providerOrderConfig;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/stock")
    public @ResponseBody List<StockDTO> getStock() {
        // This returns a JSON or XML with the users
        return stockService.getStock();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client-orders/createOrder")
    public @ResponseBody List<OrderArticleDetailDTO> createNewOrder(@RequestBody OrderContext orderContext) {
        // This returns a JSON or XML with the users
        User user = userService.getLoggedUser();
        Client client = clientRepository.getByUser(user.getId());
        return this.orderService.createNewOrder(client, orderContext.getProvider(), orderContext.getDate());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/orders")
    public @ResponseBody List<Orders> getOrders() {
        // This returns a JSON or XML with the users
        List<Orders> orders = orderService.getOrders();
        orders.stream().forEach(o -> {
            o.getProvider().setClients(null);
            o.getProvider().setArticles(null);
        });
        return orders;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/client-orders/getById")
    public @ResponseBody Orders getOrderById(@RequestParam Long id) {
        // This returns a JSON or XML with the users
        Orders order = orderRepository.findOne(id);
        return order;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/client-orders/getOrderArticleDetailById")
    public @ResponseBody List<OrderArticleDetailDTO> getOrderArticlesDetailById(@RequestParam Long id) {
        // This returns a JSON or XML with the users
        return orderService.getOrderArticlesDetail(id);
    }
}
