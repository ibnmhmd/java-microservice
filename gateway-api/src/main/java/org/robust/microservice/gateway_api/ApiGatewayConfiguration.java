package org.robust.microservice.gateway_api;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> RouteFunction = route -> route.path("/get")
				.filters(f -> f.addRequestHeader("API-GATEWAY-HEADER", "GATEWAY_HEADER")
						       .addRequestParameter("GATE-WAY-PARAM", "PARAM"))
				.uri("http://httpbin.org:80");
		
		Function<PredicateSpec, Buildable<Route>> CELbRouter = route -> route.path("/api/currency-exchange/**").uri("lb://CURRENCY-EXCHANGE");
		Function<PredicateSpec, Buildable<Route>> CCLbRouter = route -> route.path("/api/currency-conversion/**").uri("lb://CURRENCY-CONVERSION");
		return builder.routes()
				.route(RouteFunction )
				.route(CELbRouter)
				.route(CCLbRouter)
				.build()
;	}
}
