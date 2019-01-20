package com.shadov.codehellven.api.code.domain


import com.shadov.codehellven.api.code.entity.CodeResponse
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

internal interface CodeResponseRepository : MongoRepository<CodeResponse, String> {
    fun findByCallbackId(callbackId: String): Optional<CodeResponse>
}
