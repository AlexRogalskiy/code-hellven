package com.shadov.codehellven.api.infrastructure.external

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:external-services.properties")
@ConfigurationProperties("external-service")
internal open class ServiceEndpoints {
    lateinit var codeExecution: String
}
