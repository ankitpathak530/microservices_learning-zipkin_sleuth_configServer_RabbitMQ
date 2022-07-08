package com.demo.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString 
public class CurrencyConversionBean {
	

	  private Long id;
	  private String from;
	  private String to;
	  private BigDecimal conversionMultiple;
	  private BigDecimal quantity;
	  private BigDecimal totalCalculatedAmount;
	  private int port;
}