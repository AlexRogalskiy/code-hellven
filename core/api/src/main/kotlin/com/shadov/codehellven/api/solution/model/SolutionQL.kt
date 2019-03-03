package com.shadov.codehellven.api.solution.model

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.model.SortingDirection
import com.shadov.codehellven.api.task.model.TaskQL
import com.shadov.codehellven.api.task.model.asGraphQL
import com.shadov.codehellven.api.user.model.asGraphQL
import com.shadov.codehellven.api.user.model.UserQL
import com.shadov.codehellven.common.model.Languages
import java.time.LocalDateTime

internal data class SolutionQL(private val solutionEntity: SolutionEntity) {
    val runningTime: Int = solutionEntity.runningTime
    val codeSnippet: CodeSnippet = solutionEntity.codeSnippet
    val finisher: UserQL = solutionEntity.finisher.asGraphQL()
    val task: TaskQL = solutionEntity.task.asGraphQL()
    val submitDate: LocalDateTime = solutionEntity.submitDate
}

internal data class SolutionFilter(
        val finisherName: String?,
        val taskName: String?,
        val language: Languages?,
        val runningLongerThan: Int?,
        val runningShorterThan: Int?,
        val submittedAfter: LocalDateTime?,
        val submittedBefore: LocalDateTime?
)

internal data class SolutionSort(
        val field: SolutionSortField,
        val direction: SortingDirection = SortingDirection.ASC
)

enum class SolutionSortField(val fieldName: String) {
    RUNNING_TIME("runningTime"),
    SUBMIT_DATE("submitDate"),
    LANGUAGE("codeSnippet.language")
}