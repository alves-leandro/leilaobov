package com.bovauction.bovwallet.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 92, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CardInfo> cardInfoList = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String cpf, String email, String type) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<CardInfo> getCardInfoList() {
        return cardInfoList;
    }

    public void setCardInfoList(List<CardInfo> cardInfoList) {
        this.cardInfoList = cardInfoList;
    }

    public void addCardInfo(CardInfo cardInfo) {
        cardInfo.setClient(this);
        cardInfoList.add(cardInfo);
    }
}
