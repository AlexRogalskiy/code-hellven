package com.shadov.codehellven.api.code.model

import com.shadov.codehellven.common.model.CodeSnippet
import com.shadov.codehellven.api.task.model.TaskQL
import com.shadov.codehellven.api.task.model.asGraphQL
import com.shadov.codehellven.api.user.model.UserQL
import com.shadov.codehellven.api.user.model.asGraphQL
import java.time.LocalDateTime

internal data class CodeResponseQL(
        private val codeResponseEntity: CodeResponseEntity
) {
    val callbackId: String = codeResponseEntity.callbackId.toHexString()
    val codeRequest: CodeRequestQL = codeResponseEntity.codeRequest.asGraphQL()
    val completed: Boolean = codeResponseEntity.completed
    val errorStream: String? = codeResponseEntity.errorStream
    val output: String = codeResponseEntity.output
    val runningTime: Int = codeResponseEntity.runningTime
    val responseDate: LocalDateTime = codeResponseEntity.responseDate
}

internal data class CodeRequestQL(
        private val codeRequestEntity: CodeRequestEntity
) {
    val callbackId: String = codeRequestEntity.messageId!!.toHexString()
    val submitter: UserQL = codeRequestEntity.submitter.asGraphQL()
    val task: TaskQL = codeRequestEntity.task.asGraphQL()
    val codeSnippet: CodeSnippet = codeRequestEntity.codeSnippet
    val requestDate: LocalDateTime = codeRequestEntity.requestDate
}

internal data class SubmitCodeRequest(
        val submitterName: String,
        val taskName: String,
        val codeSnippet: CodeSnippet
)

internal data class AcceptCodeResponse(
        val callbackId: String,
        val completed: Boolean,
        val output: String,
        val errorStream: String?,
        val runningTime: Int
)