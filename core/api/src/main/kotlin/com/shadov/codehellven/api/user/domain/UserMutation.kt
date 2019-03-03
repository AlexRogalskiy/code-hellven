package com.shadov.codehellven.api.user.domain

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.shadov.codehellven.api.user.model.CreateUserInput
import com.shadov.codehellven.api.user.model.UserQL
import com.shadov.codehellven.api.user.model.asEntity
import com.shadov.codehellven.api.user.model.asGraphQL
import io.vavr.collection.List as VavrList

internal class UserMutation(private val userRepository: UserRepository) : GraphQLMutationResolver {
    fun createUser(createUserInput: CreateUserInput): UserQL {
        return userRepository.save(createUserInput.asEntity()).asGraphQL()
    }
}
