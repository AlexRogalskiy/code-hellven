package com.shadov.codehellven.api.code.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.code.model.CodeResponseQL
import com.shadov.codehellven.api.code.model.CodeResponseEntity
import com.shadov.codehellven.api.code.model.asGraphQL
import io.vavr.collection.List as VavrList

internal class CodeQuery(
        private val codeResponseRepository: CodeResponseRepository
) : GraphQLQueryResolver {
    fun codeResponse(callbackId: String): CodeResponseQL {
        return codeResponseRepository.findByCallbackId(callbackId)
                .map(CodeResponseEntity::asGraphQL)
                .orElseThrow { IllegalArgumentException("Code response for callback = $callbackId was not found") }
    }

}
