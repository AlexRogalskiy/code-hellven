package com.shadov.codehellven.api.user.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.api.user.entity.asGraphQL
import io.vavr.collection.List as VavrList

internal class UserQuery(private val userRepository: UserRepository) : GraphQLQueryResolver {

    fun user(name: String): User {
        return userRepository.findByName(name)
                .map(UserEntity::asGraphQL)
                .orElseThrow { IllegalArgumentException("User with name = $name not found") }

    }
}
