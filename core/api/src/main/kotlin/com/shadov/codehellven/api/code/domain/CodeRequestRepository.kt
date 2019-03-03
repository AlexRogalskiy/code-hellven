package com.shadov.codehellven.api.code.domain


import com.shadov.codehellven.api.code.model.CodeRequestEntity
import org.springframework.data.mongodb.repository.MongoRepository

internal interface CodeRequestRepository : MongoRepository<CodeRequestEntity, String>
