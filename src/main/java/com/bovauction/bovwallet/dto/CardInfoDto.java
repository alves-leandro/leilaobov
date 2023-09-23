package com.bovauction.bovwallet.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CardInfoDto {
    @NotEmpty(message = "Race can not be empty")
    private String race;
    @NotNull(message = "Age can not be null")
    private int age;
    @NotNull(message = "Value can not be null")
    @DecimalMin(value = "0.01", message = "Value must be higher than 0.01")
    private double price;
    @NotEmpty(message = "URL image can not be empty")
    private String urlImage;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
