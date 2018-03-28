package com.test.stock.stockservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFoundException extends Exception{
    public StockNotFoundException(String message){
        super(message);
    }
}