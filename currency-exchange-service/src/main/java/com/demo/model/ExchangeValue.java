package com.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ExchangeValue {
	  @Id
	  private Long id;
	  
	  @Column(name="currency_from")
	  private String from;
	  
	  @Column(name="currency_to")
	  private String to;
	  
	  private BigDecimal conversionMultiple;
	  private int port;
}
