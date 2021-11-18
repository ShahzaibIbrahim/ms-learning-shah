package com.shah.microservices.currencyexchangeservice.controller;

import com.shah.microservices.currencyexchangeservice.beans.CurrencyExchange;
import com.shah.microservices.currencyexchangeservice.data.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue (@PathVariable String to, @PathVariable String from) {
        /*CurrencyExchange currencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(50));
        */
        CurrencyExchange currencyExchange =  repository.findByFromAndTo(from, to);

        if(currencyExchange==null) {
            throw new RuntimeException("No data found");
        }

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));


        return currencyExchange;
    }
}
