package com.darothub.stockapi.service;

import com.darothub.stockapi.entity.Stock;
import com.darothub.stockapi.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockServices {
    private final StockRepository stockRepository;
    @Override
    public Collection<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(long id) {
        Optional<Stock> s = stockRepository.findById(id);
        return s.orElse(null);
    }

    @Override
    public Stock updateStock(Stock stock, long id) {
        Stock s = getStockById(id);
        if(s != null){
            stock.setId(id);
            stock.setCreateDate(s.getCreateDate());
            stock.setLastUpdate(LocalDateTime.now());
            return stockRepository.save(stock);
        }
        return null;
    }

    @Override
    public Stock addStock(Stock stock) {
        stock.setCreateDate(LocalDateTime.now());
        stock.setLastUpdate(LocalDateTime.now());
        return stockRepository.save(stock);
    }
}
