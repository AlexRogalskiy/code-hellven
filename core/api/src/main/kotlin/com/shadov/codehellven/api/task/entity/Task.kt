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
internal open class Task(
        @Id
        var taskId: String? = null,
        @Indexed
        @DBRef
        var creator: User,
        @Indexed(unique = true)
        val name: String,
        val description: String,
        val methodSignature: String,
        val className: String,
        var tags: Set<String> = Sets.newHashSet(),
        var active: Boolean = false,
        var failedAttempts: Int = 0,
        var likeCount: Int = 0,
        @Indexed
        var difficulty: Difficulty,
        @DBRef(lazy = true)
        var solutions: Set<Solution> = Sets.newHashSet(),
        var tests: Map<Languages, String> = Maps.newHashMap(),
        var initialCode: Map<Languages, String> = Maps.newHashMap()
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
