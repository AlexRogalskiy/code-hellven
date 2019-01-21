package com.shadov.codehellven.api.task.domain.exception

internal class TaskUpdateException(override val message: String = "Exception occured during task update") : RuntimeException(message)