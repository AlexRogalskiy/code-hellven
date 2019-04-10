package com.shadov.codehellven.api.code.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.code.model.CodeResponseEntity
import com.shadov.codehellven.api.code.model.CodeResponseQL
import com.shadov.codehellven.api.code.model.asGraphQL
import com.shadov.codehellven.api.model.exception.orNotFoundException
import com.shadov.codehellven.common.lazyLogger
import org.bson.types.ObjectId
import io.vavr.collection.List as VavrList

internal class CodeQuery(
        private val codeResponseRepository: CodeResponseRepository
) : GraphQLQueryResolver {
    private val log by lazyLogger()

    fun findCodeResponse(callbackId: String): CodeResponseQL {
        log.info("Searching for code response with callbackId = $callbackId")

        return codeResponseRepository.findByCallbackId(ObjectId(callbackId))
                .map(CodeResponseEntity::asGraphQL)
                .orNotFoundException("Code response for callback = $callbackId was not found")
    }
}
