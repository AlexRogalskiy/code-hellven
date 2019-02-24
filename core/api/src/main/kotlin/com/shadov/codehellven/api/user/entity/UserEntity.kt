package com.shadov.codehellven.api.user.entity

import com.google.common.collect.Sets
import com.shadov.codehellven.api.task.entity.TaskEntity
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import io.vavr.collection.HashMap as VavrHashMap
import io.vavr.collection.List as VavrList
import io.vavr.collection.Map as VavrMap

@Document("users")
internal class UserEntity(
        @Id
        var userId: ObjectId? = null,
        @DBRef(lazy = true)
        var completedTasks: MutableSet<TaskEntity> = Sets.newHashSet(),
        @DBRef(lazy = true)
        var likedTasks: MutableSet<TaskEntity> = Sets.newHashSet(),
        @DBRef(lazy = true)
        var givenUpTasks: MutableSet<TaskEntity> = Sets.newHashSet(),
        @Indexed(unique = true)
        val name: String,
        val lastLoginDate: LocalDateTime = LocalDateTime.now()
) {
    fun getReputation(): Int {
        return completedTasks.map(TaskEntity::getReputationWorth).sum()
    }
}