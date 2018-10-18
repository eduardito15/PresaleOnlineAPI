package com.presaleonline.presaleonlineapi.service;

import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Stock;
import com.presaleonline.presaleonlineapi.dto.StockDTO;

import java.util.List;

public interface StockService {

    List<StockDTO> getStock();

    Stock getStockByClient(Client client);

    List<StockDTO> getStockDTOByClient(Long clientId);

}
