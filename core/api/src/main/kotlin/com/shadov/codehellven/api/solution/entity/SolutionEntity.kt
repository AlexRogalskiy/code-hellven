package com.shadov.codehellven.api.solution.entity

import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
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
        val finisher: UserEntity,
        @DBRef
        val task: TaskEntity,
        val submitDate: LocalDateTime = LocalDateTime.now()
)

internal fun SolutionEntity.asGraphQL(): SolutionQL {
    return SolutionQL(this)
}