package com.darothub.stockapi.service;

import com.darothub.stockapi.entity.Stock;

import java.util.Collection;

public interface StockServices {
    Collection<Stock> getAllStock();
    Stock getStockById(long id);
    Stock updateStock(Stock stock, long id);
    Stock addStock(Stock stock);

}
