package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.task.domain.exception.TaskUpdateException
import com.shadov.codehellven.api.task.entity.Task
import io.vavr.control.Either
import io.vavr.control.Try

internal class TaskFacade(private val taskRepository: TaskRepository) : TaskApi {
    override fun failedAttempt(task: Task): Either<TaskUpdateException, Task> {
        return Try.of { taskRepository.save(task.copy(failedAttempts = task.failedAttempts + 1)) }
                .toEither(TaskUpdateException())
    }

}