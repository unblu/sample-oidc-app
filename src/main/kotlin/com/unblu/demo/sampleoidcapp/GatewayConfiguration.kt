package com.unblu.demo.sampleoidcapp

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayConfiguration {

	@Bean
	fun routes(builder: RouteLocatorBuilder) = builder.routes {
		route(id = "unblu-untrusted-backend") {
			order(5)
			path("/unblu/**")
			filters {
				setRequestHeader("Authorization","Bearer TODO_TOKEN")
			}
			//uri("http://10.152.183.68:8080")
			uri("http://localhost:7777")
		}

	}
}

