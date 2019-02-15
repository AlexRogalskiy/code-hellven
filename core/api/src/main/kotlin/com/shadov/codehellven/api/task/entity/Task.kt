package com.shadov.codehellven.api.task.entity

import com.shadov.codehellven.api.solution.entity.Solution
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.solution.entity.asGraphQL
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.api.user.entity.asGraphQL
import com.shadov.codehellven.common.model.Difficulty
import io.vavr.kotlin.toVavrList
import io.vavr.collection.List as VavrList

internal data class Task(private val taskEntity: TaskEntity) {
    val name: String = taskEntity.name
    val description: String = taskEntity.description
    val tags: VavrList<String> = taskEntity.tags.toVavrList()
    val active: Boolean = taskEntity.active
    val failedAttempts: Int = taskEntity.failedAttempts
    val likeCount: Int = taskEntity.likeCount
    val difficulty: Difficulty = taskEntity.difficulty

    val completedCount: Int by lazy {
        taskEntity.getCompletedCount()
    }

    val creator: User by lazy {
        taskEntity.creator.asGraphQL()
    }

    val solutions: VavrList<Solution> by lazy {
        taskEntity.solutions.toVavrList().map(SolutionEntity::asGraphQL)
    }
}