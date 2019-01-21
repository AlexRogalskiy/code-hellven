package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.task.entity.CommonTaskProjection
import com.shadov.codehellven.api.user.entity.NameUserProjection
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.rest.core.config.Projection

@Projection(name = "fullSolutionProjection", types = arrayOf(Solution::class))
internal interface FullSolutionProjection {
    val code: String
    val runningTime: Long
    val language: Languages
    val user: NameUserProjection
    val task: CommonTaskProjection
}

@Projection(name = "commonSolutionProjection", types = arrayOf(Solution::class))
internal interface CommonSolutionProjection {
    val code: String
    val runningTime: Long
    val language: Languages
    val user: NameUserProjection
}


