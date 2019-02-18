package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.user.domain.UserQuery
import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class TaskConfiguration {
    @Bean
    open fun userQuery(userRepository: UserRepository): UserQuery {
        return UserQuery(userRepository)
    }
}