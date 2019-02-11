package com.shadov.codehellven.api.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.graphql.asGraphQL
import com.shadov.codehellven.api.graphql.types.Task
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.domain.UserRepository
import io.vavr.kotlin.toVavrList
import io.vavr.collection.List as VavrList

internal class TaskQuery(private val taskRepository: TaskRepository, private val userRepository: UserRepository) : GraphQLQueryResolver {
    fun createdBy(creator: String): VavrList<Task> {
        return taskRepository.findByCreatorName(creator).toVavrList()
                .map(TaskEntity::asGraphQL)
    }

    fun completedBy(completedBy: String): VavrList<Task> {
        return userRepository.findByName(completedBy)
                .map { user -> user.completedTasks.map(TaskEntity::asGraphQL).toVavrList() }
                .orElseThrow { IllegalArgumentException("User with name = $completedBy was not found") }
    }
}
