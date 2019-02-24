package com.shadov.codehellven.api.user.domain

import com.shadov.codehellven.api.user.entity.CreateUserInput
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.api.user.entity.UserQL

internal fun UserEntity.asGraphQL(): UserQL {
    return UserQL(this)
}

internal fun CreateUserInput.asEntity(): UserEntity {
    return UserEntity(
            name = this.name
    )
}