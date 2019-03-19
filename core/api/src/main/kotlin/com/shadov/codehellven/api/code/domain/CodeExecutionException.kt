package com.shadov.codehellven.api.code.domain

import com.shadov.codehellven.api.model.exception.AppException

internal open class CodeExecutionException : AppException("Could not execute submitted code request")