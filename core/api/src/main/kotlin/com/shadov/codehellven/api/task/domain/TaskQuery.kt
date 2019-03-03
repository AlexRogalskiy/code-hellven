package com.shadov.codehellven.api.task.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.model.PageInput
import com.shadov.codehellven.api.model.PagedResponse
import com.shadov.codehellven.api.model.asPagedResponse
import com.shadov.codehellven.api.model.asRequest
import com.shadov.codehellven.api.task.model.*
import com.shadov.codehellven.api.user.domain.UserRepository
import io.vavr.collection.List as VavrList

internal class TaskQuery(private val taskRepository: TaskRepository, private val userRepository: UserRepository) : GraphQLQueryResolver {
    fun searchTasks(filter: TaskFilter, sort: VavrList<TaskSort>, page: PageInput): PagedResponse<TaskQL> {
        return taskRepository.findAll(filter.toPredicate(), page.asRequest(sort.asSort()))
                .map(TaskEntity::asGraphQL)
                .asPagedResponse()
    }
}
