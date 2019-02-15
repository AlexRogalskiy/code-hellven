package com.shadov.codehellven.api.infrastructure.graphql

import com.shadov.codehellven.api.solution.domain.SolutionQuery
import com.shadov.codehellven.api.solution.domain.SolutionRepository
import com.shadov.codehellven.api.task.domain.TaskQuery
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.user.domain.UserQuery
import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class GraphQLConfiguration {
    @Bean
    open fun graphQLExceptionHandler() : GraphQLExceptionHandler {
        return GraphQLExceptionHandler()
    }

    @Bean
    open fun userQuery(userRepository: UserRepository): UserQuery {
        return UserQuery(userRepository)
    }

    @Bean
    open fun taskQuery(taskRepository: TaskRepository, userRepository: UserRepository): TaskQuery {
        return TaskQuery(taskRepository, userRepository)
    }

    @Bean
    open fun solutionQuery(solutionRepository: SolutionRepository, taskRepository: TaskRepository, userRepository: UserRepository): SolutionQuery {
        return SolutionQuery(solutionRepository, taskRepository, userRepository)
    }
}