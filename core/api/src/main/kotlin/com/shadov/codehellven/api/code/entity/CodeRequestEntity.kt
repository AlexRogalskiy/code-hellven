package com.shadov.codehellven.api.code.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
internal class CodeRequestEntity(
        @Id
        var messageId: String? = null,
        @DBRef
        @Indexed
        val submitter: UserEntity,
        @DBRef
        @Indexed
        val task: TaskEntity,
        val codeSnippet: CodeSnippet,
        val requestDate: LocalDateTime = LocalDateTime.now()
)

internal fun CodeRequestEntity.asGraphQL(): CodeRequest {
    return CodeRequest(this)
}