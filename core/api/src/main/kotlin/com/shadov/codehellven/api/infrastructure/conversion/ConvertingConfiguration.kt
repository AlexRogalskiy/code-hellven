package com.shadov.codehellven.api.infrastructure.conversion

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mapping.context.MappingContext

@Configuration
internal open class ConvertingConfiguration {
    @Bean
    open fun entityConverter(mappingContext: MappingContext<*, *>, applicationContext: ApplicationContext): EntityConverter {
        return EntityConverter(mappingContext, applicationContext)
    }
}