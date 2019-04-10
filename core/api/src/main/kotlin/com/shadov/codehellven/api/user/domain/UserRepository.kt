package com.shadov.codehellven.api.user.domain

import com.shadov.codehellven.api.user.model.UserEntity
import io.vavr.control.Option
import org.springframework.data.mongodb.repository.MongoRepository

internal interface UserRepository : MongoRepository<UserEntity, String>, UserRepositoryCustom {
    fun findByName(name: String): Option<UserEntity>

    fun existsByName(name: String): Boolean
}
