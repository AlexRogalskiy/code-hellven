package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.model.UserEntity
import com.shadov.codehellven.common.model.Difficulty
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import java.util.*
import io.vavr.collection.List as VavrList

internal interface TaskRepository : MongoRepository<TaskEntity, String>, TaskRepositoryCustom, QuerydslPredicateExecutor<TaskEntity> {
    fun findByCreator(creator: UserEntity) : List<TaskEntity>

    fun findByNameIgnoreCase(name: String): Optional<TaskEntity>

    fun findByNameStartingWithIgnoreCase(name: String, page: Pageable): Page<TaskEntity>

    fun findByDescriptionIgnoreCase(description: String, pageable: Pageable): Page<TaskEntity>

    fun findByCreatorIgnoreCase(creator: UserEntity, pageable: Pageable): Page<TaskEntity>

    fun findByDifficulty(difficulty: Difficulty, pageable: Pageable): Page<TaskEntity>

    fun findTop10ByOrderByCompletedCountDesc(): List<TaskEntity>

    fun findByActiveIsTrue(pageable: Pageable): Page<TaskEntity>
}
