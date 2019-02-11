package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("solutions")
internal data class SolutionEntity(
        @Id
        val solutionId: String? = null,
        val code: String,
        val runningTime: Long,
        val language: Languages,
        @DBRef
        val user: UserEntity,
        @DBRef
        val task: TaskEntity
)
