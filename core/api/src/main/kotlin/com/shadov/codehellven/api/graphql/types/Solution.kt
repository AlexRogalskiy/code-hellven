package com.shadov.codehellven.api.graphql.types

import com.shadov.codehellven.api.graphql.asGraphQL
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.common.model.Languages

internal data class Solution(private val solutionEntity: SolutionEntity) {
    val code: String = solutionEntity.code
    val runningTime: Int = solutionEntity.runningTime.toInt()
    val language: Languages = solutionEntity.language
    val user: User = solutionEntity.user.asGraphQL()
    val task: Task = solutionEntity.task.asGraphQL()
}