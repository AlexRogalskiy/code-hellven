package com.shadov.codehellven.api.infrastructure

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter

import java.util.concurrent.TimeUnit

@Configuration
internal open class GlobalRepositoryConfiguration : RepositoryRestConfigurerAdapter() {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        config.corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                .allowedHeaders("*")
                .exposedHeaders("WWW-Authenticate")
                .allowCredentials(true)
                .maxAge(TimeUnit.DAYS.toSeconds(1))
    }
}
