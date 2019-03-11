package com.shadov.codehellven.api.infrastructure.graphql

import com.oembedler.moon.graphql.boot.error.ThrowableGraphQLError
import com.shadov.codehellven.api.model.exception.AppException
import com.shadov.codehellven.api.model.exception.TechnicalException
import org.springframework.web.bind.annotation.ExceptionHandler

internal class GraphQLExceptionHandler {
    @ExceptionHandler(AppException::class)
    fun handleGenericException(ex: AppException): ThrowableGraphQLError {
        return ThrowableGraphQLError(ex)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ThrowableGraphQLError {
        return ThrowableGraphQLError(TechnicalException())
    }
}