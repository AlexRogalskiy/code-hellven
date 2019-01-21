package com.shadov.codehellven.api.user.entity

import org.springframework.data.rest.core.config.Projection

@Projection(name = "userNameProjection", types = arrayOf(User::class))
interface NameUserProjection {
    val name: String
}