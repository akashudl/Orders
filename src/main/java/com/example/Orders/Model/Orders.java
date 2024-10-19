package com.example.Orders.Model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;


public class Orders {


    @Valid private List<OrderInfo> orderInfoList;

    public List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(orderInfoList, orders.orderInfoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderInfoList);
    }


    @Override
    public String toString() {
        return "Orders{" +
                "orderInfoList=" + orderInfoList +
                '}';
    }
}
