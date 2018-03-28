package com.test.stock.stockservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stock extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CURRENT_PRICE")
    private long currentPrice;

    public Stock(String name, long currentPrice){
        this.name = name;
        this.currentPrice =currentPrice;
    }
}
