package com.shadov.codehellven.api.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.graphql.asGraphQL
import com.shadov.codehellven.api.graphql.types.Solution
import com.shadov.codehellven.api.solution.domain.SolutionRepository
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.task.domain.TaskRepository
import io.vavr.kotlin.toVavrList
import io.vavr.collection.List as VavrList

internal class SolutionQuery(private val solutionRepository: SolutionRepository, private val taskRepository: TaskRepository) : GraphQLQueryResolver {

    fun userSolutions(user: String): VavrList<Solution> {
        return solutionRepository.findByUserName(user).toVavrList()
                .map(SolutionEntity::asGraphQL)
    }

    fun taskSolutions(task: String): VavrList<Solution> {
        return taskRepository.findByNameIgnoreCase(task)
                .map { task -> task.solutions.map(SolutionEntity::asGraphQL).toVavrList() }
                .orElseThrow { IllegalArgumentException("Task with name = $task was not found") }
    }
}
