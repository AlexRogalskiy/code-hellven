package com.shadov.codehellven.api.model.exception

import io.vavr.control.Option
import java.util.*

internal open class DataNotFoundException(message: String) : AppException(message)

internal fun <T> Option<T>.orNotFoundException(message: String): T {
    return this.getOrElseThrow { DataNotFoundException(message) }
}

internal fun <T> Optional<T>.orNotFoundException(message: String): T {
    return this.orElseThrow { DataNotFoundException(message) }
}