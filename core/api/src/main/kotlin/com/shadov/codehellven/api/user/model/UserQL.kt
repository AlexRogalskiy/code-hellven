package com.shadov.codehellven.api.user.model

import com.shadov.codehellven.api.task.model.TaskQL
import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.task.model.asGraphQL
import io.vavr.kotlin.toVavrList
import java.time.LocalDateTime
import io.vavr.collection.List as VavrList

internal data class UserQL(private val userEntity: UserEntity) {
    val name: String = userEntity.name
    val lastLoginDate: LocalDateTime = userEntity.lastLoginDate

    val reputation: Int by lazy {
        userEntity.getReputation()
    }

    val completedTasks: VavrList<TaskQL> by lazy {
        userEntity.completedTasks.toVavrList().map(TaskEntity::asGraphQL)
    }
    val likedTasks: VavrList<TaskQL> by lazy {
        userEntity.likedTasks.toVavrList().map(TaskEntity::asGraphQL)
    }
    val givenUpTasks: VavrList<TaskQL> by lazy {
        userEntity.givenUpTasks.toVavrList().map(TaskEntity::asGraphQL)
    }
}

internal data class CreateUserInput(
        val name: String
)