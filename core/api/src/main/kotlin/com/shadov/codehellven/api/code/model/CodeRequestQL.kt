package com.shadov.codehellven.api.code.model

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.model.TaskQL
import com.shadov.codehellven.api.task.model.asGraphQL
import com.shadov.codehellven.api.user.model.asGraphQL
import com.shadov.codehellven.api.user.model.UserQL
import java.time.LocalDateTime

internal data class CodeRequestQL(
        private val codeRequestEntity: CodeRequestEntity
) {
    val submitter: UserQL = codeRequestEntity.submitter.asGraphQL()
    val task: TaskQL = codeRequestEntity.task.asGraphQL()
    val codeSnippet: CodeSnippet = codeRequestEntity.codeSnippet
    val requestDate: LocalDateTime = codeRequestEntity.requestDate
}