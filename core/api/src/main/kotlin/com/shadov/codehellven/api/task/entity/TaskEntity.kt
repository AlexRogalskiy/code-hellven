package com.shadov.codehellven.api.task.entity

import com.google.common.collect.Maps
import com.google.common.collect.Sets
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.common.model.Difficulty
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("tasks")
internal class TaskEntity(
        @Id
        val taskId: String? = null,
        @Indexed
        @DBRef
        val creator: UserEntity,
        @Indexed(unique = true)
        val name: String,
        val description: String,
        val methodSignature: String,
        val className: String,
        val tags: Set<String> = Sets.newHashSet(),
        val active: Boolean = false,
        val failedAttempts: Int = 0,
        val likeCount: Int = 0,
        @Indexed
        val difficulty: Difficulty,
        @DBRef(lazy = true)
        var solutions: Set<SolutionEntity> = Sets.newHashSet(),
        val tests: Map<Languages, String> = Maps.newHashMap(),
        val initialCode: Map<Languages, String> = Maps.newHashMap()
) {
    fun getReputationWorth(): Int {
        return difficulty.reputation()
    }

    fun getCompletedCount(): Int {
        return solutions.size
    }
}
