package com.example.Orders.Model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;


import java.util.Objects;


public class OrderInfo {
    private String assetIdentifier;


    private String transactionType;
    private String orderType;



    @Min(1)
    private int quantity;

    @Min(value = 1, message = "Must be greater than one")
    private  int amount;

    @NotNull
    private String exchange;

    public String getAssetIdentifier() {
        return assetIdentifier;
    }

    public void setAssetIdentifier(String assetIdentifier) {
        this.assetIdentifier = assetIdentifier;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return Objects.equals(assetIdentifier, orderInfo.assetIdentifier) && Objects.equals(transactionType, orderInfo.transactionType) && Objects.equals(orderType, orderInfo.orderType) && Objects.equals(exchange, orderInfo.exchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetIdentifier, transactionType, orderType, exchange);
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "assetIdentifier='" + assetIdentifier + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", orderType='" + orderType + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
