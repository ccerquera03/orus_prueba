package com.sumer.login.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LoginUserDto {
    @NotBlank
    @Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El correo debe ser valido")
    private String email;
    @NotBlank
    private String password;
}
