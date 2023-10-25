package com.sumer.login.repository.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class OrderFruit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double totalPrice;
    private String fruits;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderCreation;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderUpdate;
}
