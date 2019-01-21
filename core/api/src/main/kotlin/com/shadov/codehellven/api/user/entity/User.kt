package com.shadov.codehellven.api.user.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.google.common.collect.Sets
import com.shadov.codehellven.api.Application
import com.shadov.codehellven.api.infrastructure.conversion.EntityConverter
import com.shadov.codehellven.api.task.entity.Task
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.hateoas.Link
import java.time.LocalDateTime

@Document
internal open class User(
        @Id
        var userId: String? = null,
        @DBRef(lazy = true)
        var completedTasks: Set<Task> = Sets.newHashSet(),
        @DBRef(lazy = true)
        var likedTasks: Set<Task> = Sets.newHashSet(),
        @DBRef(lazy = true)
        var givenUpTasks: Set<Task> = Sets.newHashSet(),
        @Indexed(unique = true)
        val name: String,
        var lastLoginDate: LocalDateTime = LocalDateTime.now()
) {
    fun getReputation(): Int {
        return completedTasks.map(Task::getReputationWorth).sum()
    }

    companion object {
        @JsonCreator
        @JvmStatic
        fun deserialize(content: String): User {
            return Application.context.getBean(EntityConverter::class.java).convert(Link(content), User::class.java)
        }
    }
}
