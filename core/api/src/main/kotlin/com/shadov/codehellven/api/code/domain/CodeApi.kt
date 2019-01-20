package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.code.domain.exception.CodeExecutionException
import com.shadov.codehellven.api.code.entity.CodeRequest
import io.vavr.control.Either

internal interface CodeApi {
    fun execute(request: CodeRequest): Either<CodeExecutionException, String>
}