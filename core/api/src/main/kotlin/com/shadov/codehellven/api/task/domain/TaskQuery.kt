package com.shadov.codehellven.api.task.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.model.pagination.PageInput
import com.shadov.codehellven.api.model.pagination.PagedResponse
import com.shadov.codehellven.api.model.pagination.asPagedResponse
import com.shadov.codehellven.api.model.pagination.asRequest
import com.shadov.codehellven.api.task.model.*
import com.shadov.codehellven.api.user.domain.UserRepository
import com.shadov.codehellven.common.lazyLogger
import io.vavr.collection.List as VavrList

internal class TaskQuery(private val taskRepository: TaskRepository, private val userRepository: UserRepository) : GraphQLQueryResolver {
    private val log by lazyLogger()

    fun searchTasks(filter: TaskFilter, sort: VavrList<TaskSort>, page: PageInput): PagedResponse<TaskQL> {
        log.info("Searching for tasks with filter = $filter")

        return taskRepository.findAll(filter.toPredicate(), page.asRequest(sort.asSort()))
                .map(TaskEntity::asGraphQL)
                .asPagedResponse()
    }
}
