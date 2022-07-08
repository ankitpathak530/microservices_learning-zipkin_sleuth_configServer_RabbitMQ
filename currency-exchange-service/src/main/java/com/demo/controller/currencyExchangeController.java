package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.ExchangeValue;
import com.demo.repository.ExchangeValueRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class currencyExchangeController {

	@Autowired
	
	private ExchangeValueRepository exchangeValueRepository;
	
	@Autowired
	Environment environment;
	
	 @GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		 
		log.info("Currency-exchange-service   currencyExchange-Controller   currencyExchangeController() started...");
	    ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
	    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	    log.info("Currency-exchange-service   currencyExchange-Controller   currencyExchangeController() completed... exchangeValue->",exchangeValue);
		
	    return exchangeValue;
	  }
}
