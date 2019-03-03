package com.shadov.codehellven.api.task.model

import com.google.common.collect.Sets
import com.shadov.codehellven.api.model.CodeSnippet
import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.api.user.model.UserEntity
import com.shadov.codehellven.common.model.Difficulty
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("tasks")
internal class TaskEntity(
        @Id
        var taskId: ObjectId? = null,
        @Indexed
        @DBRef
        val creator: UserEntity,
        @Indexed(unique = true)
        val name: String,
        val description: String,
        @Indexed
        val tags: MutableSet<String> = Sets.newHashSet(),
        val active: Boolean = false,
        val failedAttempts: Int = 0,
        val likeCount: Int = 0,
        @Indexed
        val difficulty: Difficulty,
        val completedCount: Int = 0,
        @DBRef(lazy = true)
        var solutions: MutableSet<SolutionEntity> = Sets.newHashSet(),
        val tests: MutableSet<CodeSnippet> = Sets.newHashSet(),
        val initialCode: MutableSet<CodeSnippet> = Sets.newHashSet()
) {
    fun getReputationWorth(): Int {
        return difficulty.reputation()
    }
}