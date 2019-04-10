package com.shadov.codehellven.api.user.domain.events

import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.api.user.domain.UserRepository
import com.shadov.codehellven.common.lazyLogger
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent

internal class UserCompleteTaskListener(
        private val userRepository: UserRepository
) : AbstractMongoEventListener<SolutionEntity>() {
    private val log by lazyLogger()

    override fun onAfterSave(event: AfterSaveEvent<SolutionEntity>) {
        log.info("Solution was saved, UserCompleteTask event called - updating solution's completer accordingly")

        userRepository.completeTask(event.source)
                .onFailure { ex -> log.error("Could not add task ${event.source.task.name} to completed by user ${event.source.finisher.name}", ex) }
    }
}