package com.shadov.codehellven.api.code.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class CodeConfiguration {
    @Bean
    open fun codeApi(codeRequestRepository: CodeRequestRepository): CodeApi {
        return CodeFacade(codeRequestRepository)
    }

    @Bean
    open fun codeQuery(codeResponseRepository: CodeResponseRepository): CodeQuery {
        return CodeQuery(codeResponseRepository)
    }
}