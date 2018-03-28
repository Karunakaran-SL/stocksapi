package com.test.stock.stockservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StockServiceException extends Exception {
    public StockServiceException(String message){
        super(message);
    }

}
