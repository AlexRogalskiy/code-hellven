package com.shadov.codehellven.api.task.entity

import com.shadov.codehellven.api.user.entity.NameUserProjection
import com.shadov.codehellven.common.model.Difficulty
import org.springframework.data.rest.core.config.Projection

@Projection(name = "commonTaskProjection", types = arrayOf(Task::class))
interface CommonTaskProjection {
    val creator: NameUserProjection
    val name: String
    val tags: Set<String>
    val active: Boolean
    val likeCount: Int
    val difficulty: Difficulty
    val failedAttempts: Int
}
