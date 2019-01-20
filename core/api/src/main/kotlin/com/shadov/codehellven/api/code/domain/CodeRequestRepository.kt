package com.shadov.codehellven.api.code.domain


import com.shadov.codehellven.api.code.entity.CodeRequest
import org.springframework.data.mongodb.repository.MongoRepository

internal interface CodeRequestRepository : MongoRepository<CodeRequest, String>
