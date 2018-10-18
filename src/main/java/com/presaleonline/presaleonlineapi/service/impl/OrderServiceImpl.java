package com.presaleonline.presaleonlineapi.service.impl;

import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.OrderArticleDetailDTO;
import com.presaleonline.presaleonlineapi.repository.OrderRepository;
import com.presaleonline.presaleonlineapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private StockService stockService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Orders> getOrders() {
        List<Orders> result = new ArrayList<>();
        User user = userService.getLoggedUser();
        if(user.getUserType().equals(UserType.CLIENT.toString())) {
            Client client = clientService.getByUser(user);
            result = orderRepository.getOrdersByClient(client);
        } else if (user.getUserType().equals(UserType.PROVIDER.toString())) {
            Provider provider = providerService.getByUser(user);
            result = orderRepository.getOrdersByProvider(provider);
        }
        return result;
    }

    @Override
    public List<OrderArticleDetailDTO> getOrderArticlesDetail(Long orderId) {
        Orders one = orderRepository.findOne(orderId);
        List<OrderArticleDetailDTO> result = new ArrayList<>();
        one.getOrderItemList().forEach(orderItem -> {
            OrderArticleDetailDTO orderArticleDetailDTO = new OrderArticleDetailDTO();
            orderArticleDetailDTO.setArticleCode(orderItem.getArticle().getCode());
            orderArticleDetailDTO.setArticleName(orderItem.getArticle().getLongDescription());
            orderArticleDetailDTO.setQuantity(orderItem.getQuantity());
            result.add(orderArticleDetailDTO);
        });
        return result;
    }

    @Override
    public List<OrderArticleDetailDTO> createNewOrder(Client client, Provider provider, Date date) {
        Orders ord = new Orders();
        ord.setClient(client);
        ord.setProvider(providerService.getById(provider.getId()));
        ord.setDate(date);
        ord.setOrderItemList(createItemsListForNewOrder(ord));
        orderRepository.save(ord);
        return getOrderArticlesDetail(ord.getId());
    }

    private List<OrderItem> createItemsListForNewOrder(Orders ord) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Stock stock = stockService.getStockByClient(ord.getClient());
        List<StockItem>  stockItemList = stock.getItems().stream().filter(si-> ord.getProvider().getArticles().contains(si.getArticle())).collect(Collectors.toList());
        for (StockItem si: stockItemList) {
            OrderItem oi = new OrderItem();
            oi.setArticle(si.getArticle());
            oi.setQuantity(si.getIdealQuantity()-si.getQuantity());
            orderItemList.add(oi);
        }
        return orderItemList;
    }
}
