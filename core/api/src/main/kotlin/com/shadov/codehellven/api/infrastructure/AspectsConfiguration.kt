package com.shadov.codehellven.api.infrastructure

import com.shadov.codehellven.api.infrastructure.aspects.RepositoryCallLoggingAspect
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order

@Configuration
internal open class AspectsConfiguration {
    @Bean
    @Order(1)
    open fun repositoryCallLoggingAspect() = RepositoryCallLoggingAspect(LoggerFactory.getLogger(Loggers.REPOSITORY_CALLS.loggerName))
}