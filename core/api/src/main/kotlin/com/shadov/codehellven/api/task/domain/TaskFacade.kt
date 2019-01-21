package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.task.domain.exception.TaskUpdateException
import com.shadov.codehellven.api.task.entity.Task
import io.vavr.control.Either
import io.vavr.control.Try

internal class TaskFacade(private val taskRepository: TaskRepository) : TaskApi {
    override fun failure(taskId: String): Either<TaskUpdateException, Task> {
        return Try.of {
            val saved = taskRepository.findById(taskId).orElseThrow { TaskUpdateException("Task does not exist") }
            val modified = saved.apply { this.failedAttempts = saved.failedAttempts + 1 }
            return@of taskRepository.save(modified)
        }.toEither(TaskUpdateException())
    }

}