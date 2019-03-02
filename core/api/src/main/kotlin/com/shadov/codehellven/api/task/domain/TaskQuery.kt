package com.shadov.codehellven.api.task.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.task.entity.TaskQL
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.task.entity.asGraphQL
import com.shadov.codehellven.api.user.domain.UserRepository
import com.shadov.codehellven.api.user.entity.UserEntity
import io.vavr.kotlin.toVavrList
import io.vavr.collection.List as VavrList

internal class TaskQuery(private val taskRepository: TaskRepository, private val userRepository: UserRepository) : GraphQLQueryResolver {
    fun createdBy(creator: String): VavrList<TaskQL> {
        return userRepository.findByName(creator)
                .map(taskRepository::findByCreator)
                .map { it.toVavrList() }
                .orElseThrow { IllegalArgumentException("User with name = $creator not found") }
                .map(TaskEntity::asGraphQL)
    }

    fun completedBy(completedBy: String): VavrList<TaskQL> {
        return userRepository.findByName(completedBy)
                .map(UserEntity::completedTasks)
                .map { it.toVavrList() }
                .orElseThrow { IllegalArgumentException("User with name = $completedBy not found") }
                .map(TaskEntity::asGraphQL)
    }
}
