package com.shadov.codehellven.api.task.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.solution.entity.SolutionQL
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.solution.entity.asGraphQL
import com.shadov.codehellven.api.user.domain.asGraphQL
import com.shadov.codehellven.api.user.entity.UserQL
import com.shadov.codehellven.common.model.Difficulty
import io.vavr.kotlin.toVavrList
import io.vavr.kotlin.toVavrSet
import io.vavr.collection.List as VavrList
import io.vavr.collection.Set as VavrSet

internal data class TaskQL(private val taskEntity: TaskEntity) {
    val name: String = taskEntity.name
    val description: String = taskEntity.description
    val tags: VavrList<String> = taskEntity.tags.toVavrList()
    val active: Boolean = taskEntity.active
    val failedAttempts: Int = taskEntity.failedAttempts
    val likeCount: Int = taskEntity.likeCount
    val difficulty: Difficulty = taskEntity.difficulty
    val tests: VavrSet<CodeSnippet> = taskEntity.tests.toVavrSet()
    val initialCode: VavrSet<CodeSnippet> = taskEntity.initialCode.toVavrSet()
    val completedCount: Int = taskEntity.completedCount

    val creator: UserQL by lazy {
        taskEntity.creator.asGraphQL()
    }

    val solutions: VavrList<SolutionQL> by lazy {
        taskEntity.solutions.toVavrList().map(SolutionEntity::asGraphQL)
    }
}