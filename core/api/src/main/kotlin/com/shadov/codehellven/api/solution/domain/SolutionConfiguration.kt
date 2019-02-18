package com.shadov.codehellven.api.solution.domain

import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class SolutionConfiguration {
    @Bean
    open fun solutionQuery(solutionRepository: SolutionRepository, taskRepository: TaskRepository, userRepository: UserRepository): SolutionQuery {
        return SolutionQuery(solutionRepository, taskRepository, userRepository)
    }
}