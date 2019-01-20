package com.shadov.codehellven.api.solution.domain

import com.shadov.codehellven.api.solution.entity.Solution
import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.user.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.*

@RepositoryRestResource
internal interface SolutionRepository : MongoRepository<Solution, String> {
    @RestResource
    fun findSolutionByUserAndTask(user: User, task: Task): Optional<Solution>

    @RestResource
    override fun findById(id: String): Optional<Solution>

    @RestResource
    override fun <S : Solution> save(solution: S): S

    @RestResource
    override fun findAll(page: Pageable): Page<Solution>
}

