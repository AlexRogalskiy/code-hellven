package com.shadov.codehellven.api

import com.shadov.codehellven.api.Application.Companion.context
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy
internal open class Application {
    companion object {
        lateinit var context: ApplicationContext
    }
}

fun main(args: Array<String>) {
    context = runApplication<Application>(*args)
}