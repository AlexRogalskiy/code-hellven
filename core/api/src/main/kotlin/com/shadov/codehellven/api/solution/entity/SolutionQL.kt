package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.entity.TaskQL
import com.shadov.codehellven.api.task.entity.asGraphQL
import com.shadov.codehellven.api.user.domain.asGraphQL
import com.shadov.codehellven.api.user.entity.UserQL
import java.time.LocalDateTime

internal data class SolutionQL(private val solutionEntity: SolutionEntity) {
    val runningTime: Int = solutionEntity.runningTime
    val codeSnippet: CodeSnippet = solutionEntity.codeSnippet
    val finisher: UserQL = solutionEntity.finisher.asGraphQL()
    val task: TaskQL = solutionEntity.task.asGraphQL()
    val submitDate: LocalDateTime = solutionEntity.submitDate
}