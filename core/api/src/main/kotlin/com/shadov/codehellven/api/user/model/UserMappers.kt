package com.shadov.codehellven.api.user.model

internal fun UserEntity.asGraphQL(): UserQL {
    return UserQL(this)
}

internal fun CreateUserInput.asEntity(): UserEntity {
    return UserEntity(
            name = this.name
    )
}