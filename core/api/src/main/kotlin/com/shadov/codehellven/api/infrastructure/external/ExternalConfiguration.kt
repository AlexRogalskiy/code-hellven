package com.shadov.codehellven.api.infrastructure.external

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
internal open class ExternalConfiguration {
    @Bean
    @LoadBalanced
    open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}