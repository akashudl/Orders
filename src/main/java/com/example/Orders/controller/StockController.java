package com.example.Orders.controller;

import com.example.Orders.Model.Orders;
import com.example.Orders.service.OrderPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/order")
public class StockController {
    private static final Logger LOGGER = Logger.getLogger("StockController.class");

    @Autowired
    private OrderPlacementService orderPlacementService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Integer> placeOrder(@Valid @RequestBody Orders orders) {
//        LOGGER.info("Input received :: " + orders);
        Integer orderId = null;
        try {
            System.out.print("Done");


            orderId = orderPlacementService.placeOrder(orders);

        } catch (Exception e) {
            LOGGER.info("Error Occured at " + e.getMessage());
        }
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/status/{orderId}")
    public ResponseEntity<String> getOrderStatus(@PathVariable Integer orderId ){
        String status=orderPlacementService.getOrderStatus(orderId);
        return ResponseEntity.ok(status);
    }

}

