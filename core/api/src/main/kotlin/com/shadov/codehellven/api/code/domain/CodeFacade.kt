package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.code.domain.exception.CodeExecutionException
import com.shadov.codehellven.api.code.entity.CodeRequest
import io.vavr.control.Either

internal class CodeFacade(private val codeRequestRepository: CodeRequestRepository) : CodeApi {
    override fun execute(request: CodeRequest): Either<CodeExecutionException, String> {
        val savedRequest = codeRequestRepository.save(request)

        //TODO rest call to logic module

        return Either.right(savedRequest.messageId)
    }
}