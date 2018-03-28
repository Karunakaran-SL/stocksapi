package com.test.stock.stockservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Stock extends BaseModel{

    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENT_PRICE")
    private String currentPrice;
}
