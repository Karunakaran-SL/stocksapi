package com.test.stock.stockservice;

import com.test.stock.stockservice.exception.StockNotFoundException;
import com.test.stock.stockservice.exception.StockServiceException;
import com.test.stock.stockservice.model.Stock;
import com.test.stock.stockservice.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest {

    @Autowired
    StockService stockService;

    @Test
    public void testGetAllStocks() throws StockNotFoundException {
        List<Stock> stocks = stockService.getAllStocks();
        Stock stock = stocks.stream().filter( s -> s.getName().equalsIgnoreCase("GOOL"))
                .findFirst().get();
        assertEquals(stock.getCurrentPrice(),600);
        assertEquals(stock.getName(),"GOOL");
    }

    @Test
    public void testGetStocks() throws Exception {
        Stock stock = stockService.getStockById(2);
        assertEquals(stock.getCurrentPrice(),600);
        assertEquals(stock.getName(),"GOOL");
    }

    @Test(expected = StockNotFoundException.class)
    public void testGetStocksInvalid() throws Exception {
        stockService.getStockById(20);
    }

    @Test(expected = StockServiceException.class)
    public void testCreateStockInvalid() throws Exception{
        stockService.createOrUpdateStock(new Stock());
    }

    @Test(expected = StockServiceException.class)
    public void testCreateStockWithName() throws Exception{
        Stock stock = new Stock();
        stock.setName("IBM");
        stockService.createOrUpdateStock(stock);
    }

    @Test
    public void testCreateStock() throws Exception{
        Stock stock = new Stock();
        stock.setName("IBM");
        stock.setCurrentPrice(400);
        Stock stock1 = stockService.createOrUpdateStock(stock);
        assertEquals(stock.getCurrentPrice(),400);
        assertEquals(stock.getName(),"IBM");
    }

}
