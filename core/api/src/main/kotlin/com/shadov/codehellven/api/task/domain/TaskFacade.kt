package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.task.domain.exception.TaskUpdateException
import com.shadov.codehellven.api.task.entity.TaskEntity
import io.vavr.control.Either
import io.vavr.control.Try

internal class TaskFacade(private val taskRepository: TaskRepository) : TaskApi {
    override fun failure(taskId: String): Either<TaskUpdateException, TaskEntity> {
        return Try.of {
            val saved = taskRepository.findById(taskId).orElseThrow { TaskUpdateException("TaskEntity does not exist") }
            val modified = saved.copy ( failedAttempts = saved.failedAttempts + 1 )
            return@of taskRepository.save(modified)
        }.toEither(TaskUpdateException())
    }

}