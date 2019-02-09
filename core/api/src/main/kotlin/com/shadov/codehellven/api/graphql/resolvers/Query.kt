package com.shadov.codehellven.api.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shadov.codehellven.api.graphql.types.Solution
import com.shadov.codehellven.api.graphql.types.Task
import com.shadov.codehellven.api.graphql.types.User
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
internal class Query : GraphQLQueryResolver {

    fun user(name: String) : User {
        return User(name = "John", lastLoginDate = LocalDateTime.now())
    }

    fun createdBy(creator: String) : List<Task> {
        return listOf(Task(name = "created task"))
    }

    fun completedBy(completedBy: String) : List<Task> {
        return listOf(Task(name = "completed task"))
    }

    fun userSolutions(user: String) : List<Solution> {
        return listOf(Solution(code = "new gg"))
    }

    fun taskSolutions(task: String) : List<Solution> {
        return listOf(Solution(code = "task gg"))
    }
}
