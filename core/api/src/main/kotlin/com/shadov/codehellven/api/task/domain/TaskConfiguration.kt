package com.shadov.codehellven.api.task.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class TaskConfiguration {
    @Bean
    open fun taskApi(taskRepository: TaskRepository): TaskApi {
        return TaskFacade(taskRepository)
    }
}