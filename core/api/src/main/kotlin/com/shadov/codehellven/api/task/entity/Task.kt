package com.shadov.codehellven.api.task.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.google.common.collect.Maps
import com.google.common.collect.Sets
import com.shadov.codehellven.api.Application
import com.shadov.codehellven.api.infrastructure.conversion.EntityConverter
import com.shadov.codehellven.api.solution.entity.Solution
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.common.model.Difficulty
import com.shadov.codehellven.common.model.Languages
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.hateoas.Link

@Document
internal data class Task(
        @Id
        val taskId: String? = null,
        @Indexed
        @DBRef
        val creator: User,
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
        @DBRef
        val solutions: Set<Solution> = Sets.newHashSet(),
        val tests: Map<Languages, String> = Maps.newHashMap(),
        val initialCode: Map<Languages, String> = Maps.newHashMap()
) {
    fun getReputationWorth(): Int {
        return difficulty.reputation()
    }

    fun getCompletedCount(): Int {
        return solutions.size
    }

    companion object {
        @JsonCreator
        @JvmStatic
        fun deserialize(content: String): Task {
            return Application.context.getBean(EntityConverter::class.java).convert(Link(content), Task::class.java)
        }
    }
}
