package com.shadov.codehellven.api.solution.domain.events

import com.shadov.codehellven.api.solution.domain.SolutionRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class SolutionEventsConfiguration {
    @Bean
    open fun solutionUploadedListener(solutionRepository: SolutionRepository): SolutionUploadedListener {
        return SolutionUploadedListener(solutionRepository)
    }
}