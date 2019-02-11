package com.shadov.codehellven.api.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.graphql.asGraphQL
import com.shadov.codehellven.api.graphql.types.User
import com.shadov.codehellven.api.user.domain.UserRepository
import com.shadov.codehellven.api.user.entity.UserEntity
import io.vavr.collection.List as VavrList

internal class UserQuery(private val userRepository: UserRepository) : GraphQLQueryResolver {

    fun user(name: String): User {
        return userRepository.findByName(name)
                .map(UserEntity::asGraphQL)
                .orElseThrow { IllegalArgumentException("User with name = $name not found") }

    }
}
