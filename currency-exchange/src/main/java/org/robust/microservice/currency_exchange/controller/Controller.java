package org.robust.microservice.currency_exchange.controller;

import org.robust.microservice.currency_exchange.bean.CurrencyExchange;
import org.robust.microservice.currency_exchange.repository.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private CurrencyExchangeRepo currencyRepo;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/api/currency-exchange/{from}/to/{to}")
	public CurrencyExchange getExchange(@PathVariable String from, @PathVariable String to) { 
		CurrencyExchange currency = this.currencyRepo.findByFromAndTo(from, to);
		
		if(currency == null) {
			throw new RuntimeException("No currency was found");
		}
		currency.setEnvironment("SERVER-"+this.environment.getProperty("local.server.port"));
		return currency;
	}

}
