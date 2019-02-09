package com.shadov.codehellven.api.code.domain


import com.shadov.codehellven.api.code.entity.CodeResponseEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

internal interface CodeResponseRepository : MongoRepository<CodeResponseEntity, String> {
    fun findByCallbackId(callbackId: String): Optional<CodeResponseEntity>
}
