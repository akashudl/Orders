package com.example.Orders.service;

import com.example.Orders.Model.OrderInfo;
import com.example.Orders.Model.Orders;
import com.example.Orders.repo.ExchangeIdRepo;
import com.example.Orders.repo.ExchangeJpa;
import com.example.Orders.repo.OrderPlacementRepository;
import com.example.Orders.repo.OrdersJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class OrderPlacementServiceImpl implements OrderPlacementService {

    @Autowired
    private OrderPlacementRepository orderPlacementRepository;

    @Autowired
    private ExchangeIdRepo exchangeIdRepo;

    private static final Logger LOGGER = Logger.getLogger("OrderPlacementServiceImpl.class");

    @Override
    public Integer placeOrder(Orders orders) {
        LOGGER.info("Input received IN SERVICE CLASS:: " + orders);
        List<OrdersJpa> ordersJpaList = new ArrayList<>();

        for (OrderInfo order : orders.getOrderInfoList()) {
            String exchangeName=order.getExchange();
            ExchangeJpa exchange=getExchangeID(exchangeName);
            LOGGER.info("ExchangeId: -> "+ exchange.getExchangeId());
            OrdersJpa ordersJpa = new OrdersJpa();
            ordersJpa.setAssetIdentifier(order.getAssetIdentifier());
            ordersJpa.setExchangeId(exchange.getExchangeId());
            ordersJpa.setStockExchange(null);
            ordersJpa.setStockName(null);
            ordersJpa.setTransactionType(order.getTransactionType());
            ordersJpa.setOrderType(order.getOrderType());
            ordersJpa.setQuantity(order.getQuantity());
            ordersJpa.setAmount(order.getAmount());
            ordersJpaList.add(ordersJpa);
        }
        Iterable<OrdersJpa> ordersJpas = orderPlacementRepository.saveAll(ordersJpaList);
        return ordersJpas.iterator().next().getId();
    }

    @Override
    public ExchangeJpa getExchangeID(String exchangeName) {

        return exchangeIdRepo.findByExchangeName(exchangeName);

    }

    @Override
    public String getOrderStatus(Integer orderId) {
        OrdersJpa status=orderPlacementRepository.findByid(orderId);
        LOGGER.info("Order Id is : "+status);
        if (status==null){
            return "Order id don't exist";
        }
        //OrdersJpa CheckStatus=orderPlacementRepository.findBystatus(status.getId());
        LOGGER.info(status.getStatus());
        String order_status=status.getStatus();
        if(order_status.equals("INPROGRESS")){
            LOGGER.info("Order will be cancelled");
            status.setStatus("DECLINED");
            orderPlacementRepository.save(status);
        }

        return "Order id"+status.getId()+" has been declind";
    }


}

