package org.robust.microservice.currency_conversion.controller;

import java.math.BigDecimal;

import org.robust.microservice.currency_conversion.entity.CurrencyConversion;
import org.robust.microservice.currency_conversion.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= {"api/currency-conversion/from"})
public class Controller {

	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversion conversion = this.proxy.getExchange(from, to);
		
		return new  CurrencyConversion(conversion.getId() , from , to , quantity , 
				    conversion.getConversionMultiple(), quantity.multiply(conversion.getConversionMultiple()),
				    conversion.getEnvironment());
	}
}
