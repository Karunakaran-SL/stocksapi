package com.test.stock.stockservice.service.impl;

import com.test.stock.stockservice.exception.StockNotFoundException;
import com.test.stock.stockservice.exception.StockServiceException;
import com.test.stock.stockservice.model.Stock;
import com.test.stock.stockservice.repo.StockRepository;
import com.test.stock.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() throws StockNotFoundException {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(int id) throws StockNotFoundException {
        return stockRepository.findById(id).orElseThrow(() -> new StockNotFoundException("Stock not found with id:"+id));
    }

    @Override
    public Stock createStock(Stock stock) throws StockServiceException {
        isValidStock(stock,false);
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) throws StockServiceException {
        isValidStock(stock,true);
        return stockRepository.save(stock);
    }

    private boolean isValidStock(Stock stock,boolean isModify) throws StockServiceException{
        if(isModify && stock.getId()<=0){
            throw new StockServiceException(String.format("Stock with id : %s not found",stock.getId()));
        }

        if(StringUtils.isEmpty(stock.getName())){
            throw new StockServiceException("Name not provided");
        }

        if(stock.getCurrentPrice() == 0){
            throw new StockServiceException("Current price not provided");
        }
        return true;
    }
}
