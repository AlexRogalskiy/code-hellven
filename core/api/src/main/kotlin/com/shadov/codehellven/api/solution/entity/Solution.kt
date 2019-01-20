package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
internal data class Solution(
        @Id
        val solutionId: String? = null,
        val code: String,
        val runningTime: Long,
        val language: Languages,
        @DBRef
        val user: User,
        @DBRef
        val task: Task
)
