package com.shadov.codehellven.api.user.entity

import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.task.entity.asGraphQL
import io.vavr.kotlin.toVavrList
import java.time.LocalDateTime
import io.vavr.collection.List as VavrList

internal data class User(private val userEntity: UserEntity) {
    val name: String = userEntity.name
    val lastLoginDate: LocalDateTime = userEntity.lastLoginDate

    val reputation: Int by lazy {
        userEntity.getReputation()
    }

    val completedTasks: VavrList<Task> by lazy {
        userEntity.completedTasks.toVavrList().map(TaskEntity::asGraphQL)
    }
    val likedTasks: VavrList<Task> by lazy {
        userEntity.likedTasks.toVavrList().map(TaskEntity::asGraphQL)
    }
    val givenUpTasks: VavrList<Task> by lazy {
        userEntity.givenUpTasks.toVavrList().map(TaskEntity::asGraphQL)
    }
}