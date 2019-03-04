package com.shadov.codehellven.api.code.domain

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.shadov.codehellven.api.code.model.*
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.user.domain.UserRepository

internal class CodeMutation(
        private val userRepository: UserRepository,
        private val taskRepository: TaskRepository,
        private val codeRequestRepository: CodeRequestRepository,
        private val codeResponseRepository: CodeResponseRepository
) : GraphQLMutationResolver {
    fun submitCodeRequest(codeRequest: SubmitCodeRequest): CodeRequestQL {
        val submitter = userRepository.findByName(codeRequest.submitterName)
                .orElseThrow { IllegalArgumentException("User with name = ${codeRequest.submitterName} not found") }

        val task = taskRepository.findByNameIgnoreCase(codeRequest.taskName)
                .orElseThrow { IllegalArgumentException("Task with name = ${codeRequest.taskName} not found") }

        return codeRequestRepository.insert(codeRequest.asEntity(submitter, task)).asGraphQL()
    }

    fun acceptCodeResponse(codeResponse: AcceptCodeResponse): CodeResponseQL {
        val matchingRequest = codeRequestRepository.findById(codeResponse.callbackId)
                .orElseThrow { IllegalArgumentException("Code request with callbackId = ${codeResponse.callbackId} not found") }

        return codeResponseRepository.insert(codeResponse.asEntity(matchingRequest)).asGraphQL()
    }
}