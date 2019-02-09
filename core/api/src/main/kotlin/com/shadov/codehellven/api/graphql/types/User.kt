package com.shadov.codehellven.api.graphql.types

import java.time.LocalDateTime

internal data class User(
        val name: String,
        val lastLoginDate: LocalDateTime
)