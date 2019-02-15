package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.common.model.Languages
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("solutions")
internal class SolutionEntity(
        @Id
        var solutionId: ObjectId? = null,
        val code: String,
        val runningTime: Int,
        val language: Languages,
        @DBRef
        val finisher: UserEntity,
        @DBRef
        val task: TaskEntity
)

internal fun SolutionEntity.asGraphQL(): Solution {
        return Solution(this)
}