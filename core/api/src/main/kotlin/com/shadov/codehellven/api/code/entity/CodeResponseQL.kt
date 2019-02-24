package com.shadov.codehellven.api.code.entity

import java.time.LocalDateTime

internal data class CodeResponseQL(
        private val codeResponseEntity: CodeResponseEntity
) {
    val callbackId: String = codeResponseEntity.callbackId
    val codeRequest: CodeRequestQL = codeResponseEntity.codeRequest.asGraphQL()
    val completed: Boolean = codeResponseEntity.completed
    val errorStream: String = codeResponseEntity.errorStream
    val output: String = codeResponseEntity.output
    val runningTime: Int = codeResponseEntity.runningTime
    val responseDate: LocalDateTime = codeResponseEntity.responseDate
}