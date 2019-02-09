package com.shadov.codehellven.api.user.domain

import com.shadov.codehellven.api.user.entity.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

internal interface UserRepository : MongoRepository<UserEntity, String> {
    fun findByName(name: String): Optional<UserEntity>
}
