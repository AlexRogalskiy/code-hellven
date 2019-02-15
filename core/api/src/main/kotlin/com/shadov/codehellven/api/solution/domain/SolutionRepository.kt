package com.shadov.codehellven.api.solution.domain

import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import io.vavr.collection.List as VavrList

internal interface SolutionRepository : MongoRepository<SolutionEntity, String> {
    fun findByFinisher(finisher: UserEntity): VavrList<SolutionEntity>

    fun findByTask(task: TaskEntity): VavrList<SolutionEntity>

    fun findByFinisherAndTask(finisher: UserEntity, task: TaskEntity): VavrList<SolutionEntity>
}

