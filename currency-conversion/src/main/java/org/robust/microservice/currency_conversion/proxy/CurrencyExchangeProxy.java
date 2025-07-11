package org.robust.microservice.currency_conversion.proxy;

import org.robust.microservice.currency_conversion.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/api/currency-exchange/{from}/to/{to}")
	public CurrencyConversion getExchange(@PathVariable String from, @PathVariable String to);
}
