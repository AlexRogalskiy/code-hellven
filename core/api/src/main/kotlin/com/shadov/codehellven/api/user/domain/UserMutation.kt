package com.shadov.codehellven.api.user.domain

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.shadov.codehellven.api.model.exception.ResourceAlreadyExistsException
import com.shadov.codehellven.api.user.model.CreateUserInput
import com.shadov.codehellven.api.user.model.UserQL
import com.shadov.codehellven.api.user.model.asEntity
import com.shadov.codehellven.api.user.model.asGraphQL
import com.shadov.codehellven.common.lazyLogger
import io.vavr.collection.List as VavrList

internal class UserMutation(private val userRepository: UserRepository) : GraphQLMutationResolver {
    private val log by lazyLogger()

    fun createUser(createUserInput: CreateUserInput): UserQL {
        if (userRepository.existsByName(createUserInput.name))
            throw ResourceAlreadyExistsException("User with name ${createUserInput.name} already exists")

        log.info("Saving new User with name = ${createUserInput.name}")

        return userRepository.save(createUserInput.asEntity()).asGraphQL()
    }
}
