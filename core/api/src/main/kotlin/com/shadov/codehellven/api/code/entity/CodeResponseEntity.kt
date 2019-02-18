package com.shadov.codehellven.api.code.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("codeResponses")
internal class CodeResponseEntity(
        @Id
        var messageId: String? = null,
        @Indexed
        val callbackId: String,
        @DBRef
        val codeRequest: CodeRequestEntity,
        @Indexed
        val completed: Boolean,
        val output: String,
        val errorStream: String,
        val runningTime: Int,
        val responseDate: LocalDateTime = LocalDateTime.now()
)

internal fun CodeResponseEntity.asGraphQL(): CodeResponse {
    return CodeResponse(this)
}