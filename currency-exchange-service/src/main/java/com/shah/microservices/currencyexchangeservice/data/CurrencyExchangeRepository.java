package com.shah.microservices.currencyexchangeservice.data;

import com.shah.microservices.currencyexchangeservice.beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
