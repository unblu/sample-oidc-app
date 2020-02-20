package com.unblu.demo.sampleoidcapp

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GatewayRoutesConfiguration(private val tokenRelay: TokenRelayGatewayFilterFactory) {

    @Bean
    fun routes(builder: RouteLocatorBuilder,
               @Value("\${unblu.backend}") backend: String) = builder.routes {

        route(id = "unblu-backend") {
            path("/unblu/**")
            filters {
                // forward the access token in an "Authorization: Bearer" header
                filter(tokenRelay.apply())
            }
            uri(backend)
        }

    }
}

