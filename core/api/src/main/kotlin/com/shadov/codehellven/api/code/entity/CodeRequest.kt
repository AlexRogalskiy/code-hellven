package com.shadov.codehellven.api.code.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.task.entity.asGraphQL
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.api.user.entity.asGraphQL
import java.time.LocalDateTime

internal data class CodeRequest(
        private val codeRequestEntity: CodeRequestEntity
) {
    val submitter: User = codeRequestEntity.submitter.asGraphQL()
    val task: Task = codeRequestEntity.task.asGraphQL()
    val codeSnippet: CodeSnippet = codeRequestEntity.codeSnippet
    val requestDate: LocalDateTime = codeRequestEntity.requestDate
}