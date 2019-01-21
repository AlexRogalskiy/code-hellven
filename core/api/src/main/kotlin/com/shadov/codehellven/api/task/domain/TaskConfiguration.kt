package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.task.domain.TaskResourceAssembler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.hateoas.EntityLinks

@Configuration
internal open class TaskConfiguration {
    @Bean
    open fun taskApi(taskRepository: TaskRepository): TaskApi {
        return TaskFacade(taskRepository)
    }

    @Bean
    open fun taskResourceAssembler(entityLinks: EntityLinks): TaskResourceAssembler {
        return TaskResourceAssembler(entityLinks)
    }
}