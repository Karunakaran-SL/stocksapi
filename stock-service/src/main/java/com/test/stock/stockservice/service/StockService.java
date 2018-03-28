package com.test.stock.stockservice.service;

import com.test.stock.stockservice.exception.StockNotFoundException;
import com.test.stock.stockservice.exception.StockServiceException;
import com.test.stock.stockservice.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> getAllStocks() throws StockNotFoundException;

    Stock getStockById(int id) throws StockNotFoundException;

    Stock createStock(Stock stock) throws StockServiceException;

    Stock updateStock(Stock stock) throws StockServiceException;
}
