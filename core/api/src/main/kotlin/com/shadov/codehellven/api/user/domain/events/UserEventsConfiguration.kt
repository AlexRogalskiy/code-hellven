package com.shadov.codehellven.api.user.domain.events

import com.shadov.codehellven.api.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class UserEventsConfiguration {
    @Bean
    open fun userCompleteTaskListener(userRepository: UserRepository): UserCompleteTaskListener {
        return UserCompleteTaskListener(userRepository)
    }
}