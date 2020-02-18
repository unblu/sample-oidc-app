package com.unblu.demo.sampleoidcapp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
class SecurityConfiguration {
    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        with(http.authorizeExchange()) {
            pathMatchers("/unblu/**", "/").authenticated()
            pathMatchers("/favicon.ico").permitAll()
        }

        http.csrf().disable()
        //http.formLogin(withDefaults())
        http.oauth2Client()
        http.oauth2Login()

        return http.build()
    }
}