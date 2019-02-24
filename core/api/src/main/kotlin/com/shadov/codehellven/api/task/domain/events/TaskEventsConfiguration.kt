package com.shadov.codehellven.api.task.domain.events

import com.shadov.codehellven.api.task.domain.TaskRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class TaskEventsConfiguration {
    @Bean
    open fun taskCompleteListener(taskRepository: TaskRepository): TaskCompleteListener {
        return TaskCompleteListener(taskRepository)
    }

    @Bean
    open fun taskAttemptFailedListener(taskRepository: TaskRepository): TaskAttemptFailedListener {
        return TaskAttemptFailedListener(taskRepository)
    }
}