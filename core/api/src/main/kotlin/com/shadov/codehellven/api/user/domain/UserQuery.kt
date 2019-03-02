package com.shadov.codehellven.api.user.domain

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.user.entity.UserQL
import com.shadov.codehellven.api.user.entity.UserEntity
import io.vavr.collection.List as VavrList

internal class UserQuery(private val userRepository: UserRepository) : GraphQLQueryResolver {

    fun user(name: String): UserQL {
        return userRepository.findByName(name)
                .map(UserEntity::asGraphQL)
                .orElseThrow { IllegalArgumentException("User with name = $name not found") }

    }
}
