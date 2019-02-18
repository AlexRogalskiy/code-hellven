package com.shadov.codehellven.api

import com.shadov.codehellven.api.Application.Companion.context
import com.shadov.codehellven.api.model.RunningBox
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@EnableConfigurationProperties(RunningBox::class)
@PropertySource("classpath:running-box.properties")
internal open class Application {
    companion object {
        lateinit var context: ApplicationContext
    }
}

fun main(args: Array<String>) {
    context = runApplication<Application>(*args)
}