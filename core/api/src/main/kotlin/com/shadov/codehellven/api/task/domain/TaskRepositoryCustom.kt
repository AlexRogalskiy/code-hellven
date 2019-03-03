package com.shadov.codehellven.api.task.domain

import com.mongodb.client.result.UpdateResult
import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.api.task.model.TaskEntity
import io.vavr.control.Try

internal interface TaskRepositoryCustom {
    fun acceptSolution(solution: SolutionEntity): Try<UpdateResult>

    fun failedAttempt(task: TaskEntity): Try<UpdateResult>
}