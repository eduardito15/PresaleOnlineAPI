package com.presaleonline.presaleonlineapi.repository;

import com.presaleonline.presaleonlineapi.domain.StockItem;
import org.springframework.data.repository.CrudRepository;

public interface StockItemRepository extends CrudRepository<StockItem, Long> {

}