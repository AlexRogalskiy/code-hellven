package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.task.entity.asGraphQL
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.api.user.entity.asGraphQL
import com.shadov.codehellven.common.model.Languages

internal data class Solution(private val solutionEntity: SolutionEntity) {
    val code: String = solutionEntity.code
    val runningTime: Int = solutionEntity.runningTime
    val language: Languages = solutionEntity.language
    val finisher: User = solutionEntity.finisher.asGraphQL()
    val task: Task = solutionEntity.task.asGraphQL()
}