package com.shadov.codehellven.api.solution.model

import com.shadov.codehellven.common.model.CodeSnippet
import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.model.UserEntity
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("solutions")
internal class SolutionEntity(
        @Id
        var solutionId: ObjectId? = null,
        val runningTime: Int,
        val codeSnippet: CodeSnippet,
        @DBRef
        @Indexed
        val finisher: UserEntity,
        @DBRef
        @Indexed
        val task: TaskEntity,
        val submitDate: LocalDateTime = LocalDateTime.now()
)