package com.shadov.codehellven.api.user.domain

import com.mongodb.client.result.UpdateResult
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import io.vavr.control.Try

internal interface UserRepositoryCustom {
    fun completeTask(solution: SolutionEntity): Try<UpdateResult>
}
