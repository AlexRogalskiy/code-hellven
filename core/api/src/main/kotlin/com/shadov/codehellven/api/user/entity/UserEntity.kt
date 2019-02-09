package com.shadov.codehellven.api.user.entity

import com.google.common.collect.Sets
import com.shadov.codehellven.api.task.entity.TaskEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
internal data class UserEntity(
        @Id
        val userId: String? = null,
        @DBRef
        val completedTasks: Set<TaskEntity> = Sets.newHashSet(),
        @DBRef
        val likedTasks: Set<TaskEntity> = Sets.newHashSet(),
        @DBRef
        val givenUpTasks: Set<TaskEntity> = Sets.newHashSet(),
        @Indexed(unique = true)
        val name: String,
        var lastLoginDate: LocalDateTime = LocalDateTime.now()
) {
    fun getReputation(): Int {
        return completedTasks.map(TaskEntity::getReputationWorth).sum()
    }
}
