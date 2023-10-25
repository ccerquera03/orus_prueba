package com.sumer.login.repository.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double price;
    private Integer amount;
    private String type;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fruitCreation;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fruitUpdate;
}
