package com.bovauction.bovwallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "card_info")
public class CardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "client_id")
//    @JoinColumn(name = "user_id")
    @JsonIgnore
//    private User user;
    private Client client;
    public CardInfo() {
    }

    public CardInfo(String race, int age, double price, String urlImage) {
        this.race = race;
        this.age = age;
        this.price = price;
        this.urlImage = urlImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Client getClient() {return  client;}

    public void setClient(Client client) { this.client = client;}

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
