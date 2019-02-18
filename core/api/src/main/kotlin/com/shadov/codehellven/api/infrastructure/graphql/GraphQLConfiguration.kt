package com.shadov.codehellven.api.infrastructure.graphql

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class GraphQLConfiguration {
    @Bean
    open fun graphQLExceptionHandler(): GraphQLExceptionHandler {
        return GraphQLExceptionHandler()
    }
}