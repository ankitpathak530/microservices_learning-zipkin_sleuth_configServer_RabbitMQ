package com.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.demo.model.ExchangeValue;
import com.demo.repository.ExchangeValueRepository;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyExchangeServiceApplication {
	
	static List<ExchangeValue> listExchanges =  List.of(
			new ExchangeValue(10001l,"USD","INR",new BigDecimal(78),0),
			new ExchangeValue(10002l,"EUR","INR",new BigDecimal(65),0),
			new ExchangeValue(10003l,"AUD","INR",new BigDecimal(75),0),
			new ExchangeValue(10004l,"USD","PINR",new BigDecimal(265),0)
			);

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
		ExchangeValueRepository repo = run.getBean(ExchangeValueRepository.class);
		
		//saving all list of exchange to database
		listExchanges.stream().forEach(e->repo.save(e));
		
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
