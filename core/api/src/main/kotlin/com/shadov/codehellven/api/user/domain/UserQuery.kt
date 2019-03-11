package com.shadov.codehellven.api.user.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.model.exception.orNotFoundException
import com.shadov.codehellven.api.user.model.UserEntity
import com.shadov.codehellven.api.user.model.UserQL
import com.shadov.codehellven.api.user.model.asGraphQL
import io.vavr.collection.List as VavrList

internal class UserQuery(private val userRepository: UserRepository) : GraphQLQueryResolver {
    fun user(name: String): UserQL {
        return userRepository.findByName(name)
                .map(UserEntity::asGraphQL)
                .orNotFoundException("User with name = $name not found")

    }
}
