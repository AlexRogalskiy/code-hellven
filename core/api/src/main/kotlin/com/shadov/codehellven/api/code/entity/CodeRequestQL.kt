package com.shadov.codehellven.api.code.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.entity.TaskQL
import com.shadov.codehellven.api.task.entity.asGraphQL
import com.shadov.codehellven.api.user.domain.asGraphQL
import com.shadov.codehellven.api.user.entity.UserQL
import java.time.LocalDateTime

internal data class CodeRequestQL(
        private val codeRequestEntity: CodeRequestEntity
) {
    val submitter: UserQL = codeRequestEntity.submitter.asGraphQL()
    val task: TaskQL = codeRequestEntity.task.asGraphQL()
    val codeSnippet: CodeSnippet = codeRequestEntity.codeSnippet
    val requestDate: LocalDateTime = codeRequestEntity.requestDate
}