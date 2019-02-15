package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.common.model.Difficulty
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*
import io.vavr.collection.List as VavrList

internal interface TaskRepository : MongoRepository<TaskEntity, String> {
    fun findByCreator(creator: UserEntity) : List<TaskEntity>

    fun findByNameIgnoreCase(name: String): Optional<TaskEntity>

    fun findByNameStartingWithIgnoreCase(name: String, page: Pageable): Page<TaskEntity>

    fun findByDescriptionIgnoreCase(description: String, pageable: Pageable): Page<TaskEntity>

    fun findByCreatorIgnoreCase(creator: UserEntity, pageable: Pageable): Page<TaskEntity>

    fun findByDifficulty(difficulty: Difficulty, pageable: Pageable): Page<TaskEntity>

    fun findTop10ByOrderByCompletedCountDesc(): List<TaskEntity>

    fun findByActiveIsTrue(pageable: Pageable): Page<TaskEntity>
}
