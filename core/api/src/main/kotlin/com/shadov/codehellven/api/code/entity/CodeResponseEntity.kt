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
internal data class CodeResponseEntity(
        @Id
        val messageId: String? = null,
        @Indexed
        val callbackId: UserEntity,
        @DBRef
        @Indexed
        val user: UserEntity,
        @DBRef
        @Indexed
        val task: TaskEntity,
        @Indexed
        val completed: Boolean,
        @Indexed
        val language: Languages,
        val output: String,
        val errorStream: String,
        val runningTime: Long,
        val responseData: LocalDateTime = LocalDateTime.now()
)
