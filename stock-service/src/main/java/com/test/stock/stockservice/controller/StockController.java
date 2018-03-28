package com.test.stock.stockservice.controller;

import com.test.stock.stockservice.exception.StockNotFoundException;
import com.test.stock.stockservice.exception.StockServiceException;
import com.test.stock.stockservice.model.Stock;
import com.test.stock.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @CrossOrigin
    @GetMapping("/api/stocks")
    public List<Stock> getAllStocks() throws StockNotFoundException {
        return stockService.getAllStocks();
    }

    @CrossOrigin
    @GetMapping("/api/stocks/{id}")
    public Stock getStockById(@PathVariable("id") Integer id) throws StockNotFoundException {
        return stockService.getStockById(id);
    }

    @CrossOrigin
    @PutMapping("/api/stocks/{id}")
    public Stock updateStock(@PathVariable("id") Integer id,  @RequestBody Stock stock) throws StockServiceException{
        return stockService.updateStock(stock);
    }

    @CrossOrigin
    @PostMapping("/api/stocks")
    public Stock createStock(@RequestBody Stock stock) throws StockServiceException{
        return stockService.createStock(stock);
    }

}
