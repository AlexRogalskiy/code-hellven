package com.shadov.codehellven.api.infrastructure.graphql

import com.oembedler.moon.graphql.boot.error.ThrowableGraphQLError
import org.springframework.web.bind.annotation.ExceptionHandler

internal class GraphQLExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ThrowableGraphQLError {
        return ThrowableGraphQLError(ex, ex.message)
    }
}