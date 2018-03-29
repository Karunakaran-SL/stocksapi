package com.test.stock.stockservice.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@Data
public class BaseModel implements Serializable{
    @UpdateTimestamp
    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new Timestamp(System.currentTimeMillis());
    }
}
