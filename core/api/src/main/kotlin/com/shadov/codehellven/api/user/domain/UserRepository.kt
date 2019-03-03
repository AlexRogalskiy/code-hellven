package com.shadov.codehellven.api.user.domain

import com.shadov.codehellven.api.user.model.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

internal interface UserRepository : MongoRepository<UserEntity, String>, UserRepositoryCustom {
    fun findByName(name: String): Optional<UserEntity>
}
