package com.shadov.codehellven.api.solution.model

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.model.TaskQL
import com.shadov.codehellven.api.task.model.asGraphQL
import com.shadov.codehellven.api.user.model.asGraphQL
import com.shadov.codehellven.api.user.model.UserQL
import java.time.LocalDateTime

internal data class SolutionQL(private val solutionEntity: SolutionEntity) {
    val runningTime: Int = solutionEntity.runningTime
    val codeSnippet: CodeSnippet = solutionEntity.codeSnippet
    val finisher: UserQL = solutionEntity.finisher.asGraphQL()
    val task: TaskQL = solutionEntity.task.asGraphQL()
    val submitDate: LocalDateTime = solutionEntity.submitDate
}