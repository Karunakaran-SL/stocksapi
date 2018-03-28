package com.test.stock.stockservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.stock.stockservice.controller.StockController;
import com.test.stock.stockservice.model.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static junit.framework.TestCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {

    @Autowired
    StockController stockController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerInjected(){
        assertNotNull(stockController);
    }

    @Test
    public void testAllStocks() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/stocks").contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andReturn();

        List<Stock> stocks = constructStocks(result.getResponse().getContentAsString());
        assertEquals(3,stocks.size());

        //Validate the detail of one stock

        Stock stock = stocks.stream().filter( s -> s.getName().equalsIgnoreCase("GOOL"))
                .findFirst().get();
        assertEquals(stock.getCurrentPrice(),600);
        assertEquals(stock.getName(),"GOOL");

    }

    @Test
    public void testGetStocks() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/stocks/2").contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().isOk()).andReturn();

        Stock stock = constructStock(result.getResponse().getContentAsString());
        assertEquals(stock.getCurrentPrice(),600);
        assertEquals(stock.getName(),"GOOL");

    }

    @Test
    public void testGetStocksInvalid() throws Exception {
        mockMvc.perform(
                get("/api/stocks/20").contentType(
                        MediaType.APPLICATION_JSON)).andExpect(
                status().isNotFound());
    }

    private Stock constructStock(String json) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,Stock.class);
    }

    private List<Stock> constructStocks(String json) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,
                mapper.getTypeFactory().constructCollectionType(List.class, Stock.class));
    }
}
