package com.presaleonline.presaleonlineapi.service.impl;

import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.StockDTO;
import com.presaleonline.presaleonlineapi.repository.StockRepository;
import com.presaleonline.presaleonlineapi.service.ClientService;
import com.presaleonline.presaleonlineapi.service.StockService;
import com.presaleonline.presaleonlineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl
                implements StockService {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private StockRepository stockRepository;


    @Override
    public List<StockDTO> getStock() {
        User user = userService.getLoggedUser();
        Stock s = null;
        if (user.getUserType().equals(UserType.CLIENT.toString())) {
            Client client = clientService.getByUser(user);
            s = stockRepository.getStockByClient(client);
        } else if (user.getUserType().equals(UserType.PROVIDER.toString())) {

        }
        List<StockDTO> stockDTOList = new ArrayList<>();
        if (s != null) {
            s.getItems().stream().forEach(si -> {
                stockDTOList.add(createStockDTOFromStockItem(si));
            });
        }
        return stockDTOList;
    }

    @Override
    public Stock getStockByClient(Client client) {
        return stockRepository.getStockByClient(client);
    }

    @Override
    public List<StockDTO> getStockDTOByClient(Long clientId) {
        List<StockDTO> result = new ArrayList<>();
        Stock s = stockRepository.getStockByClient(clientService.getClientById(clientId));
        if (s != null) {
            s.getItems().stream().forEach(si -> {
                result.add(createStockDTOFromStockItem(si));
            });
        }
        return result;
    }

    private StockDTO createStockDTOFromStockItem(StockItem si) {
        StockDTO sdto = new StockDTO();
        sdto.setArticleCode(si.getArticle().getCode());
        sdto.setArticleName(si.getArticle().getLongDescription());
        sdto.setQuantity(si.getQuantity());
        sdto.setIdealQuantity(si.getIdealQuantity());
        sdto.setMinQuantity(si.getMinQuantity());
        return sdto;
    }
}
