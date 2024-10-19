package com.example.Orders.repo;

import jakarta.persistence.*;

@Entity
@Table(name = "EXCHANGE_DTLS")
public class ExchangeJpa {


    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "Exchange_ID")
    private Integer ExchangeId;



    @Column(name="Exchange_name")
    private String exchangeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExchangeId() {
        return ExchangeId;
    }

    public void setExchangeId(Integer exchangeId) {
        ExchangeId = exchangeId;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Override
    public String toString() {
        return "ExchangeJpa{" +
                "id=" + id +
                ", ExchangeId=" + ExchangeId +
                ", exchangeName='" + exchangeName + '\'' +
                '}';
    }
}
