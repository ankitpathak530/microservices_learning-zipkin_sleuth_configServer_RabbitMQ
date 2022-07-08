package com.demo.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.feign.CurrencyExchangeFeignProxy;
import com.demo.model.CurrencyConversionBean;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CurrencyCalculationController {

	@Autowired
	private CurrencyExchangeFeignProxy currencyExchangeFeignProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		log.info("Currency-calculation-service   CurrencyCalculation-Controller   convertCurrency() started...");
		CurrencyConversionBean response = currencyExchangeFeignProxy.retrieveExchangeValue(from, to);
		log.info("Currency-calculation-service   CurrencyCalculation-Controller   convertCurrency() completed...response is -> ",response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}