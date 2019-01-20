package com.shadov.codehellven.api.infrastructure

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer

@Configuration
open class RestConfig : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(restConfig: RepositoryRestConfiguration) {
        restConfig.disableDefaultExposure()
    }
}