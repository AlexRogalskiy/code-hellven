package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.model.UserEntity
import com.shadov.codehellven.common.model.Difficulty
import io.vavr.control.Option
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import io.vavr.collection.List as VavrList

internal interface TaskRepository : MongoRepository<TaskEntity, String>, TaskRepositoryCustom, QuerydslPredicateExecutor<TaskEntity> {
    fun findByNameIgnoreCase(name: String): Option<TaskEntity>

    fun findByNameStartingWithIgnoreCase(name: String, page: Pageable): Page<TaskEntity>

    fun findByDescriptionIgnoreCase(description: String, pageable: Pageable): Page<TaskEntity>

    fun findByCreatorIgnoreCase(creator: UserEntity, pageable: Pageable): Page<TaskEntity>

    fun findByDifficulty(difficulty: Difficulty, pageable: Pageable): Page<TaskEntity>

    fun findTop10ByOrderByCompletedCountDesc(): VavrList<TaskEntity>

    fun findByActiveIsTrue(pageable: Pageable): Page<TaskEntity>
}
