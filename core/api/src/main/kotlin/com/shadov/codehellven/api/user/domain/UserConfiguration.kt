package com.shadov.codehellven.api.user.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class UserConfiguration {
    @Bean
    open fun userQuery(userRepository: UserRepository): UserQuery {
        return UserQuery(userRepository)
    }
}