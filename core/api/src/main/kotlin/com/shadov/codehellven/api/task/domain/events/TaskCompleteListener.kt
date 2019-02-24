package com.shadov.codehellven.api.task.domain.events

import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.common.lazyLogger
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent

internal class TaskCompleteListener(
        private val taskRepository: TaskRepository
) : AbstractMongoEventListener<SolutionEntity>() {
    private val log by lazyLogger()

    override fun onAfterSave(event: AfterSaveEvent<SolutionEntity>) {
        taskRepository.acceptSolution(event.source)
                .onFailure { ex -> log.error("Could not add solution to task ${event.source.task.name} after solution save", ex) }
    }
}