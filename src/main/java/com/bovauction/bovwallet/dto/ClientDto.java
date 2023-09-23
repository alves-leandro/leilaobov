package com.bovauction.bovwallet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientDto {
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "CPF can not be empty")
    @Size(max = 11, message = "CPF must be lower than 11 characters long")
    private String cpf;

    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotEmpty(message = "Type can not be empty")
    @Pattern(regexp = "(STOCK_INVESTOR|CATTLE_BREEDER)", message = "User type must be STOCK_INVESTOR or CATTLE_BREEDER")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
