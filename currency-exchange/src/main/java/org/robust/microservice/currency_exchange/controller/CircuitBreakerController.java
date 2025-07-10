package org.robust.microservice.currency_exchange.controller;

import java.util.logging.Level;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

@RestController
@RequestMapping(value = {"api/circuit-breaker"})
@FieldDefaults(makeFinal=false, level=AccessLevel.PRIVATE)
@Log
public class CircuitBreakerController {

    
	@GetMapping("/default")
	//@Retry(name = "circuit-breaker-default", fallbackMethod = "defaultEndpointFallback")
	@CircuitBreaker(name = "circuit-breaker-default", fallbackMethod = "defaultEndpointFallback")
	@RateLimiter(name = "circuit-breaker-default")
	public String defaultEndpoint() {
		log.log(Level.INFO, "**** -> executing defaultEndpoint in CircuitBreakerController");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:4000", String.class);
		
		return response.getBody();
	}
	
	public String defaultEndpointFallback(Exception e) {
		return "Default fallback method.";
	}
}
