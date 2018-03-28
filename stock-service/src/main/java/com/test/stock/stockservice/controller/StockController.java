package com.test.stock.stockservice.controller;

import com.test.stock.stockservice.exception.StockNotFoundException;
import com.test.stock.stockservice.model.Stock;
import com.test.stock.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/api/stocks")
    public List<Stock> getAllStocks() throws StockNotFoundException {
        return stockService.getAllStocks();
    }

    @GetMapping("/api/stocks/{id}")
    public Stock getStockById(@PathVariable("id") Integer id) throws StockNotFoundException {
        return stockService.getStockById(id);
    }
}
