package org.robust.microservice.limits_service.controller;

import org.robust.microservice.limits_service.bean.Limits;
import org.robust.microservice.limits_service.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
	
	@Autowired
	private Configuration config;
	
//	LimitController(Configuration config){
//		this.config = config;
//	}
	
	@GetMapping("/api/limits")
	public Limits retrieveLimits() {
		
		return new Limits(this.config.getMin() , this.config.getMax());
	}

}
