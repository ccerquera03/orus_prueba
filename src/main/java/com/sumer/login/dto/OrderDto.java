package com.sumer.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {
    private List<FruitDto> fruits;
    private Integer total;
    private Date creation;
    private Date update;
}
