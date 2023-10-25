package com.sumer.login.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class FruitDto {

    private Integer amount;
    private String type;

}

