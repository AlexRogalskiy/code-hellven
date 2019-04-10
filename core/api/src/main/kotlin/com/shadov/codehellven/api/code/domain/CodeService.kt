package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.common.lazyLogger
import com.shadov.codehellven.common.model.CodeSubmission
import io.vavr.control.Try
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

internal class CodeService(
        private val restTemplate: RestTemplate,
        private val codeExecutionEndpoint: String
) {
    private val log by lazyLogger()

    fun executeCode(codeSubmission: CodeSubmission): Try<ResponseEntity<Void>> {
        log.info("Sending code submission with callbackId = ${codeSubmission.callbackId}")

        return Try.of { restTemplate.postForEntity(codeExecutionEndpoint, codeSubmission, Void::class.java) }
                .filter { result -> result.statusCode.is2xxSuccessful }
    }
}