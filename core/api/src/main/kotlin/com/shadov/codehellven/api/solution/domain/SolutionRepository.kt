package com.shadov.codehellven.api.solution.domain

import com.shadov.codehellven.api.solution.model.SolutionEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import io.vavr.collection.List as VavrList

internal interface SolutionRepository : MongoRepository<SolutionEntity, String>, QuerydslPredicateExecutor<SolutionEntity>
