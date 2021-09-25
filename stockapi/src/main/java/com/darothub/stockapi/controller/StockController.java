package com.darothub.stockapi.controller;

import com.darothub.stockapi.entity.Stock;
import com.darothub.stockapi.response.ResponseHandlerImpl;
import com.darothub.stockapi.response.ResponseModel;
import com.darothub.stockapi.service.StockServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1")
public class StockController {
    private final StockServiceImpl stockService;
    private final ResponseHandlerImpl responseHandler;

    @GetMapping(path = "/stocks")
    public ResponseEntity<ResponseModel> getAllStock() {
        Collection<Stock> s = stockService.getAllStock();
        return responseHandler.handleSuccessResponseEntity("List of stock", HttpStatus.OK, s);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseModel> getStockById(@PathVariable String id) {
        Stock s = stockService.getStockById(Long.parseLong(id));
        return responseHandler.handleSuccessResponseEntity("Stock", HttpStatus.OK, s);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseModel> updateStock(@Valid @RequestBody Stock stock, @PathVariable String id) {
        Stock s = stockService.updateStock(stock, Long.parseLong(id));
        if(null == s){
            return responseHandler.handleSuccessResponseEntity("Stock error", HttpStatus.BAD_REQUEST, "Bad request");
        }
        return responseHandler.handleSuccessResponseEntity("Stock updated successfully", HttpStatus.OK, s);
    }
    @PostMapping(path = "/stock")
    public ResponseEntity<ResponseModel> addStock(@Valid @RequestBody Stock stock) {
        Stock s = stockService.addStock(stock);
        return responseHandler.handleSuccessResponseEntity("Stock updated successfully", HttpStatus.CREATED, s);
    }
}
