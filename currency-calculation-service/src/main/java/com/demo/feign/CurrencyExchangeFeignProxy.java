package com.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.model.CurrencyConversionBean;

@FeignClient( url="localhost:8999/currency-exchange-service" , name="currency-exchange-service")
public interface CurrencyExchangeFeignProxy {

	  @GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
