package com.shadov.codehellven.api.user.domain

import com.shadov.codehellven.api.user.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.*

@RepositoryRestResource
internal interface UserRepository : MongoRepository<User, String> {
    @RestResource
    fun findByName(name: String): Optional<User>

    @RestResource
    override fun findById(id: String): Optional<User>

    @RestResource
    override fun <S : User> save(user: S): S
}
