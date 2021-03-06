package com.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	 ExchangeValue findByFromAndTo(String from, String to);
}
