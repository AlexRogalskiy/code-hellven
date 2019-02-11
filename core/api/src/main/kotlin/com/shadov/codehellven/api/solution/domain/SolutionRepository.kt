package com.shadov.codehellven.api.solution.domain

import com.shadov.codehellven.api.solution.entity.SolutionEntity
import org.springframework.data.mongodb.repository.MongoRepository

internal interface SolutionRepository : MongoRepository<SolutionEntity, String> {
    fun findByUserName(userName: String): List<SolutionEntity>
}

