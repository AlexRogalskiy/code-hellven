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
internal data class CodeResponse(
        @Id
        val messageId: String? = null,
        @Indexed
        val callbackId: User,
        @DBRef
        @Indexed
        val user: User,
        @DBRef
        @Indexed
        val task: Task,
        @Indexed
        val completed: Boolean,
        @Indexed
        val language: Languages,
        val output: String,
        val errorStream: String,
        val runningTime: Long,
        val responseData: LocalDateTime = LocalDateTime.now()
)
