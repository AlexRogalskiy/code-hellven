package com.shadov.codehellven.api.code.entity

import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDateTime

@Document
internal data class CodeRequest(
        @Id
        val messageId: String? = null,
        @DBRef
        @Indexed
        val user: User,
        @DBRef
        @Indexed
        val task: Task,
        val code: String,
        @Indexed
        val language: Languages,
        val requestDate: LocalDateTime = LocalDateTime.now()
)
