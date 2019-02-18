package com.shadov.codehellven.api.code.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.code.entity.CodeResponse
import com.shadov.codehellven.api.code.entity.CodeResponseEntity
import com.shadov.codehellven.api.code.entity.asGraphQL
import io.vavr.collection.List as VavrList

internal class CodeQuery(
        private val codeResponseRepository: CodeResponseRepository
) : GraphQLQueryResolver {
    fun codeResponse(callbackId: String): CodeResponse {
        return codeResponseRepository.findByCallbackId(callbackId)
                .map(CodeResponseEntity::asGraphQL)
                .orElseThrow { IllegalArgumentException("Code response for callback = $callbackId was not found") }
    }

}
