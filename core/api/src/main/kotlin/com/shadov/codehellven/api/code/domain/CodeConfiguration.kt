package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.infrastructure.external.ServiceEndpoints
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
internal open class CodeConfiguration {
    @Bean
    open fun codeQuery(
            codeResponseRepository: CodeResponseRepository
    ): CodeQuery {
        return CodeQuery(codeResponseRepository)
    }

    @Bean
    open fun codeMutation(
            restTemplate: RestTemplate,
            codeRequestRepository: CodeRequestRepository,
            userRepository: UserRepository,
            taskRepository: TaskRepository,
            codeResponseRepository: CodeResponseRepository,
            serviceEndpoints: ServiceEndpoints
    ): CodeMutation {
        val codeService = codeService(restTemplate, serviceEndpoints)
        return CodeMutation(codeService, userRepository, taskRepository, codeRequestRepository, codeResponseRepository)
    }

    @Bean
    open fun codeService(restTemplate: RestTemplate, serviceEndpoints: ServiceEndpoints): CodeService {
        return CodeService(restTemplate, serviceEndpoints.codeExecution)
    }
}