package com.shadov.codehellven.api.infrastructure

import com.fasterxml.jackson.databind.Module
import io.vavr.jackson.datatype.VavrModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class VavrConifguration {
    @Bean
    open fun vavrModule(): Module {
        return VavrModule()
    }
}