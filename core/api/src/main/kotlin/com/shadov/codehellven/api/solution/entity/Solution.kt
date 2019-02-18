package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.task.entity.asGraphQL
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.api.user.entity.asGraphQL

internal data class Solution(private val solutionEntity: SolutionEntity) {
    val runningTime: Int = solutionEntity.runningTime
    val codeSnippet: CodeSnippet = solutionEntity.codeSnippet
    val finisher: User = solutionEntity.finisher.asGraphQL()
    val task: Task = solutionEntity.task.asGraphQL()
}