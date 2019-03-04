package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
            codeRequestRepository: CodeRequestRepository,
            userRepository: UserRepository,
            taskRepository: TaskRepository,
            codeResponseRepository: CodeResponseRepository
    ): CodeMutation {
        return CodeMutation(userRepository, taskRepository, codeRequestRepository, codeResponseRepository)
    }
}