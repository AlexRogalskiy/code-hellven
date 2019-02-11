package com.shadov.codehellven.api.graphql

import com.shadov.codehellven.api.graphql.types.Solution
import com.shadov.codehellven.api.graphql.types.Task
import com.shadov.codehellven.api.graphql.types.User
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import io.vavr.kotlin.toVavrList
import io.vavr.collection.List as VavrList

internal fun UserEntity.asGraphQL(): User {
    return User(this)
}

internal fun TaskEntity.asGraphQL(): Task {
    return Task(this)
}

internal fun SolutionEntity.asGraphQL(): Solution {
    return Solution(this)
}