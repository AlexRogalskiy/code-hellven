package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.code.domain.exception.CodeExecutionException
import com.shadov.codehellven.api.code.entity.CodeRequestEntity
import io.vavr.control.Either

internal interface CodeApi {
    fun execute(request: CodeRequestEntity): Either<CodeExecutionException, String>
}