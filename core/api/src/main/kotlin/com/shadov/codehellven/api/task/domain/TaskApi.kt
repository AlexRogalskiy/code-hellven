package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.task.domain.exception.TaskUpdateException
import com.shadov.codehellven.api.task.entity.Task
import io.vavr.control.Either

internal interface TaskApi {
    fun failedAttempt(task: Task): Either<TaskUpdateException, Task>
}