package com.shadov.codehellven.api.solution.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.solution.model.SolutionQL
import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.api.solution.model.asGraphQL
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.domain.UserRepository
import io.vavr.kotlin.toVavrList
import io.vavr.collection.List as VavrList

internal class SolutionQuery(
        private val solutionRepository: SolutionRepository,
        private val taskRepository: TaskRepository,
        private val userRepository: UserRepository
) : GraphQLQueryResolver {

    fun userSolutions(user: String): VavrList<SolutionQL> {
        return userRepository.findByName(user)
                .map(solutionRepository::findByFinisher)
                .map { it.toVavrList() }
                .orElseThrow { IllegalArgumentException("User with name = $user was not found") }
                .map(SolutionEntity::asGraphQL)
    }

    fun taskSolutions(task: String): VavrList<SolutionQL> {
        return taskRepository.findByNameIgnoreCase(task)
                .map(TaskEntity::solutions)
                .map { it.toVavrList() }
                .orElseThrow { IllegalArgumentException("Task with name = $task was not found") }
                .map(SolutionEntity::asGraphQL)
    }
}
