package com.shadov.codehellven.api.solution.domain.events

import com.shadov.codehellven.api.code.model.CodeResponseEntity
import com.shadov.codehellven.api.solution.domain.SolutionRepository
import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.common.lazyLogger
import io.vavr.control.Try
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent

internal class SolutionUploadedListener(
        private val solutionRepository: SolutionRepository
) : AbstractMongoEventListener<CodeResponseEntity>() {
    private val log by lazyLogger()

    override fun onAfterSave(event: AfterSaveEvent<CodeResponseEntity>) {
        log.info("CodeResponse was saved, SolutionUploaded event called - checking if response was successfully completed")

        if (event.source.completed) {
            log.info("Saved CodeResponse was a successful response, saving Solution")

            val codeRequest = event.source.codeRequest
            val solution = SolutionEntity(
                    runningTime = event.source.runningTime,
                    codeSnippet = codeRequest.codeSnippet,
                    task = codeRequest.task,
                    finisher = codeRequest.submitter,
                    submitDate = codeRequest.requestDate
            )

            Try.of { solutionRepository.insert(solution) }
                    .onFailure { ex -> log.error("Could not save solution for successful code response", ex) }
        }
    }
}