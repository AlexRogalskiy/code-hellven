package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.common.model.CodeSubmission
import io.vavr.control.Try
import org.springframework.web.client.RestTemplate

internal class CodeService(
        private val restTemplate: RestTemplate,
        private val codeExecutionEndpoint: String
) {
    fun executeCode(codeSubmission: CodeSubmission): Try<Void> {
        return Try.of { restTemplate.postForEntity(codeExecutionEndpoint, codeSubmission, Void::class.java) }
                .filter { result -> result.statusCode.is2xxSuccessful }
                .map { result -> result.body }
    }
}