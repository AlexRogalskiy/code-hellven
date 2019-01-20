package com.shadov.codehellven.api.infrastructure.conversion

import org.springframework.context.ApplicationContext
import org.springframework.core.convert.TypeDescriptor
import org.springframework.data.geo.format.DistanceFormatter
import org.springframework.data.geo.format.PointFormatter
import org.springframework.data.mapping.context.MappingContext
import org.springframework.data.mapping.context.PersistentEntities
import org.springframework.data.repository.support.DefaultRepositoryInvokerFactory
import org.springframework.data.repository.support.Repositories
import org.springframework.data.rest.core.UriToEntityConverter
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.format.support.DefaultFormattingConversionService
import org.springframework.hateoas.Link
import java.net.URI
import java.util.*

internal class EntityConverter(
        private val mappingContext: MappingContext<*, *>,
        private val applicationContext: ApplicationContext
) {
    private val conversionService: DefaultFormattingConversionService = createConversionService()

    fun createConversionService(): DefaultFormattingConversionService {
        val conversionService = DefaultFormattingConversionService()

        val entities = PersistentEntities(Arrays.asList(mappingContext))

        val repositories = Repositories(applicationContext)

        val invokerFactory = DefaultRepositoryInvokerFactory(repositories, conversionService)

        val converter = UriToEntityConverter(entities, invokerFactory, repositories)
        conversionService.addConverter(converter)
        conversionService.addFormatter(DistanceFormatter.INSTANCE)
        conversionService.addFormatter(PointFormatter.INSTANCE)

        return conversionService
    }

    fun <T> convert(link: Link, target: Class<T>): T {
        return target.cast(conversionService.convert(URI(link.href), TypeDescriptor.valueOf(target)))
    }

}