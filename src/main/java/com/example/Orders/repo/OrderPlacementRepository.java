package com.example.Orders.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPlacementRepository extends CrudRepository<OrdersJpa, Integer> {
    OrdersJpa findByid(Integer id);


}


