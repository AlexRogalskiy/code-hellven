package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class TaskConfiguration {
    @Bean
    open fun taskQuery(taskRepository: TaskRepository, userRepository: UserRepository): TaskQuery {
        return TaskQuery(taskRepository, userRepository)
    }
}