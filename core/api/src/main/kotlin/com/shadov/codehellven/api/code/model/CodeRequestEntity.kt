package com.shadov.codehellven.api.code.model

import com.shadov.codehellven.common.model.CodeSnippet
import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.model.UserEntity
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("codeRequests")
internal class CodeRequestEntity(
        @Id
        var messageId: ObjectId? = null,
        @DBRef
        @Indexed
        val submitter: UserEntity,
        @DBRef
        @Indexed
        val task: TaskEntity,
        val codeSnippet: CodeSnippet,
        val requestDate: LocalDateTime = LocalDateTime.now()
)