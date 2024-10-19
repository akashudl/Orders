package com.example.Orders.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeIdRepo extends CrudRepository<ExchangeJpa, Integer> {
    ExchangeJpa findByExchangeName(String ExchangeId);
}
