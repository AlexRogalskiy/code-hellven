package com.shadov.codehellven.api.solution.domain

import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

internal interface SolutionRepository : MongoRepository<SolutionEntity, String> {
    fun findSolutionByUserAndTask(user: UserEntity, task: TaskEntity): Optional<SolutionEntity>
}

