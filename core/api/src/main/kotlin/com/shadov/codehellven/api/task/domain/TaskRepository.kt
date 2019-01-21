package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.task.entity.Task
import com.shadov.codehellven.api.user.entity.User
import com.shadov.codehellven.common.model.Difficulty
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.*

@RepositoryRestResource
internal interface TaskRepository : MongoRepository<Task, String> {
    @RestResource
    fun findByNameIgnoreCase(name: String): Optional<Task>

    @RestResource
    fun findByNameStartingWithIgnoreCase(name: String, page: Pageable): Page<Task>

    @RestResource
    fun findByDescriptionIgnoreCase(description: String, pageable: Pageable): Page<Task>

    @RestResource
    fun findByCreatorIgnoreCase(creator: User, pageable: Pageable): Page<Task>

    @RestResource
    fun findByDifficulty(difficulty: Difficulty, pageable: Pageable): Page<Task>

    @RestResource
    fun findTop10ByOrderByCompletedCountDesc(): List<Task>

    @RestResource
    fun findByActiveIsTrue(pageable: Pageable): Page<Task>

    @RestResource
    override fun findById(id: String): Optional<Task>

    @RestResource
    override fun findAll(page: Pageable): Page<Task>

    @RestResource
    override fun <S : Task> save(task: S): S

    @RestResource
    override fun deleteById(id: String)
}
