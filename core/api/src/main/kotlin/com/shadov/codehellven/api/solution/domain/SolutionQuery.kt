package com.shadov.codehellven.api.solution.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.model.exception.orNotFoundException
import com.shadov.codehellven.api.model.pagination.PageInput
import com.shadov.codehellven.api.model.pagination.PagedResponse
import com.shadov.codehellven.api.model.pagination.asPagedResponse
import com.shadov.codehellven.api.model.pagination.asRequest
import com.shadov.codehellven.api.solution.model.*
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.user.domain.UserRepository
import com.shadov.codehellven.common.lazyLogger
import io.vavr.collection.List as VavrList

internal class SolutionQuery(
        private val solutionRepository: SolutionRepository,
        private val taskRepository: TaskRepository,
        private val userRepository: UserRepository
) : GraphQLQueryResolver {
    private val log by lazyLogger()

    fun searchSolutions(filter: SolutionFilter, sort: VavrList<SolutionSort>, page: PageInput): PagedResponse<SolutionQL> {
        log.info("Searching for solutions with filter = $filter")

        val user = filter.finisherName?.let { userName ->
            userRepository.findByName(userName)
                    .orNotFoundException("User with name $userName not found")
        }

        val task = filter.taskName?.let { taskName ->
            taskRepository.findByNameIgnoreCase(taskName)
                    .orNotFoundException("Task with name $taskName not found")
        }

        return solutionRepository.findAll(filter.toPredicate(user, task), page.asRequest(sort.asSort()))
                .map(SolutionEntity::asGraphQL)
                .asPagedResponse()
    }
}
