package com.shadov.codehellven.api.user.entity

import com.google.common.collect.Sets
import com.shadov.codehellven.api.task.entity.TaskEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("users")
internal class UserEntity(
        @Id
        val userId: String? = null,
        @DBRef(lazy = true)
        var completedTasks: Set<TaskEntity> = Sets.newHashSet(),
        @DBRef(lazy = true)
        var likedTasks: Set<TaskEntity> = Sets.newHashSet(),
        @DBRef(lazy = true)
        var givenUpTasks: Set<TaskEntity> = Sets.newHashSet(),
        @Indexed(unique = true)
        val name: String,
        val lastLoginDate: LocalDateTime = LocalDateTime.now()
) {
    fun getReputation(): Int {
        return completedTasks.map(TaskEntity::getReputationWorth).sum()
    }
}
