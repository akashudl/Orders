package com.example.Orders.service;

import com.example.Orders.Model.Orders;
import com.example.Orders.repo.ExchangeJpa;

public interface OrderPlacementService {

    public Integer placeOrder(Orders orders);

    public ExchangeJpa getExchangeID(String orders);

    public String getOrderStatus(Integer orderId);
}
