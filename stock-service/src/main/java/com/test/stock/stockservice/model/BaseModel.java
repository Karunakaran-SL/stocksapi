package com.test.stock.stockservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@Data
public class BaseModel {
    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;
}
