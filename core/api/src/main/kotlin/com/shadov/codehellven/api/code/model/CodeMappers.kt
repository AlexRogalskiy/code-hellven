package com.shadov.codehellven.api.code.model

import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.model.UserEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime

internal fun CodeRequestEntity.asGraphQL(): CodeRequestQL {
    return CodeRequestQL(this)
}

internal fun CodeResponseEntity.asGraphQL(): CodeResponseQL {
    return CodeResponseQL(this)
}

internal fun SubmitCodeRequest.asEntity(user: UserEntity, task: TaskEntity): CodeRequestEntity {
    return CodeRequestEntity(
            codeSnippet = this.codeSnippet,
            requestDate = LocalDateTime.now(),
            submitter = user,
            task = task
    )
}

internal fun AcceptCodeResponse.asEntity(codeRequest: CodeRequestEntity): CodeResponseEntity {
    return CodeResponseEntity(
            callbackId = ObjectId(this.callbackId),
            runningTime = this.runningTime,
            responseDate = LocalDateTime.now(),
            errorStream = this.errorStream,
            completed = this.completed,
            codeRequest = codeRequest,
            output = this.output
    )
}