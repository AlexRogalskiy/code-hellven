package com.shadov.codehellven.api.task.model

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.model.SortingDirection
import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.api.solution.model.SolutionQL
import com.shadov.codehellven.api.solution.model.asGraphQL
import com.shadov.codehellven.api.user.model.UserQL
import com.shadov.codehellven.api.user.model.asGraphQL
import com.shadov.codehellven.common.model.Difficulty
import io.vavr.kotlin.toVavrList
import io.vavr.kotlin.toVavrSet
import io.vavr.collection.List as VavrList
import io.vavr.collection.Set as VavrSet

internal data class TaskQL(private val taskEntity: TaskEntity) {
    val name: String = taskEntity.name
    val creator: UserQL = taskEntity.creator.asGraphQL()
    val description: String = taskEntity.description
    val tags: VavrList<String> = taskEntity.tags.toVavrList()
    val active: Boolean = taskEntity.active
    val failedAttempts: Int = taskEntity.failedAttempts
    val likeCount: Int = taskEntity.likeCount
    val difficulty: Difficulty = taskEntity.difficulty
    val tests: VavrSet<CodeSnippet> = taskEntity.tests.toVavrSet()
    val initialCode: VavrSet<CodeSnippet> = taskEntity.initialCode.toVavrSet()
    val completedCount: Int = taskEntity.completedCount

    val solutions: VavrList<SolutionQL> by lazy {
        taskEntity.solutions.toVavrList().map(SolutionEntity::asGraphQL)
    }
}

internal data class TaskFilter(
        val anyTag: VavrList<String> = VavrList.empty(),
        val difficulty: Difficulty?,
        val active: Boolean?
)

internal data class TaskSort(
        val field: TaskSortField,
        val direction: SortingDirection = SortingDirection.ASC
)

enum class TaskSortField(val fieldName: String) {
    NAME("name"),
    FAILS("failedAttempts"),
    LIKES("likeCount"),
    DIFFICULTY("difficulty"),
    COMPLETES("completedCount")
}
