package com.shadov.codehellven.api.code.entity

import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

import java.time.LocalDateTime

@Document
internal data class CodeRequestEntity(
        @Id
        val messageId: String? = null,
        @DBRef
        @Indexed
        val user: UserEntity,
        @DBRef
        @Indexed
        val task: TaskEntity,
        val code: String,
        @Indexed
        val language: Languages,
        val requestDate: LocalDateTime = LocalDateTime.now()
)
