package com.presaleonline.presaleonlineapi.service;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Orders;
import com.presaleonline.presaleonlineapi.domain.Provider;
import com.presaleonline.presaleonlineapi.dto.OrderArticleDetailDTO;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Orders> getOrders();

    List<OrderArticleDetailDTO> getOrderArticlesDetail(Long orderId);

    List<OrderArticleDetailDTO> createNewOrder(Client client, Provider provider, Date date);

}
