package com.shadov.codehellven.api.solution.model

internal fun SolutionEntity.asGraphQL(): SolutionQL {
    return SolutionQL(this)
}